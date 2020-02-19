package com.shreyaspatil.livestream

import android.annotation.SuppressLint
import androidx.annotation.MainThread
import androidx.arch.core.executor.ArchTaskExecutor
import com.shreyaspatil.livestream.data.DataStore

/**
 * LiveStream is a data holder class which can be created and used anywhere in application.
 * By using it, You can emit values to any stream with generic data from anywhere in the application.
 * Observers will receive data events when the value of subscribed stream is updated.
 * This class is designed to share data between different modules in your application.
 * @param T The type of a data.
 */
@Suppress("UNCHECKED_CAST")
class LiveStream<T : Any> : ILiveStream<T> {

    private val mStorage: DataStore<T>? = DataStore.getInstance()

    // Data Lock for synchronization
    private val mDataLock = Any()

    // Fields used for emitting values from other threads
    private var mPendingValue: Any? = UNSET
    private var mPendingKey: String? = null

    // Runnable to execute when emitting value from other thread
    private val mPostRunnable = Runnable {
        var newValue: Any?
        var newKey: String?

        synchronized(mDataLock) {
            // Obtain key and value
            newValue = mPendingValue
            newKey = mPendingKey

            // Reset Fields
            mPendingValue = UNSET
            mPendingKey = null
        }

        newKey?.let {
            // Emit Value
            set(it, newValue as T)
        }
    }

    /**
     * Subscribes to the given stream. The events are dispatched on the main thread.
     * If stream already has data set, it will be delivered to the listener.
     * You should call [unsubscribe] to stop observing LiveStream.
     *
     * @param stream Data stream.
     * @param onChangeListener The observer which will receive the events.
     * @return [StreamObserver] Reference will be useful when you'll need to call a
     * method [unsubscribe].
     */
    override fun subscribe(
        stream: String,
        onChangeListener: OnChangeListener<T>
    ): StreamObserver<T> {
        // Set listener in DataStore
        mStorage?.setListener(stream, onChangeListener)

        // If stream already having a value then inform new subscriber.
        getValue(stream)?.let {
            onChangeListener.onChange(it)
        }

        return StreamObserver(stream, onChangeListener)
    }

    /**
     * Returns the current value of a stream. Note that calling this method on a background thread
     * does not guarantee that the latest value set will be received.
     *
     * @param stream Data stream
     * @return The current value of a [stream]
     */
    override fun getValue(stream: String): T? = mStorage?.getValue(stream)

    /**
     * Sets the value. If there are active subscribers, the value will be dispatched to them.
     * This method must be called from the main thread.
     * If you need set a value from a background thread, you can use [post]
     *
     * @param stream Data stream
     * @param value The new value
     */
    @MainThread
    override fun set(stream: String, value: T?) {
        mStorage?.setValue(stream, value)
    }

    /**
     * Posts a task to main thread to set the given value.
     * This method should be called from background thread. Otherwise, you can use [set]
     * If there are active subscribers, the value will be dispatched to them.
     *
     * @param stream Data stream
     * @param value The new value
     */
    @SuppressLint("RestrictedApi")
    override fun post(stream: String, value: T?) {
        var postTask: Boolean
        synchronized(mDataLock) {
            postTask = (mPendingValue == UNSET)
            mPendingKey = stream
            mPendingValue = value
        }

        if (!postTask) {
            return
        }

        // Execute operation on main thread
        ArchTaskExecutor.getInstance().postToMainThread(mPostRunnable)
    }

    /**
     * Removes/unsubscribe the given stream observer.
     *
     * @param observer The Observer which receive events.
     * Reference can be obtained from [subscribe].
     */
    override fun unsubscribe(observer: StreamObserver<T>) {
        mStorage?.removeListener(observer.stream, observer.onChangeListener)
    }

    /**
     * A simple callback that can retrieve from [LiveStream].
     *
     * @see LiveStream For a usage description.
     */
    interface OnChangeListener<T> {

        /**
         * Called when the data is changed.
         *
         * @param value The new data
         */
        fun onChange(value: T?)
    }

    companion object {
        private val UNSET = Any()
    }
}