package com.shreyaspatil.livestream

import android.annotation.SuppressLint
import androidx.annotation.MainThread
import androidx.arch.core.executor.ArchTaskExecutor
import com.shreyaspatil.livestream.data.DataStore

// TODO Documentation
@Suppress("UNCHECKED_CAST")
class LiveStream<T : Any> : ILiveStream<T> {

    private val mStorage: DataStore<T>? = DataStore.getInstance()

    private val mDataLock = Any()

    private var mPendingValue: Any? = UNSET
    private var mPendingKey: String? = null

    private val mPostRunnable = Runnable {
        var newValue: Any?
        var newKey: String?

        synchronized(mDataLock) {
            newValue = mPendingValue
            newKey = mPendingKey

            mPendingValue = UNSET
            mPendingKey = null
        }

        newKey?.let {
            set(it, newValue as T)
        }
    }

    override fun subscribe(
        stream: String,
        onChangeListener: OnChangeListener<T>
    ): StreamObserver<T> {
        mStorage?.setListener(stream, onChangeListener)
        return StreamObserver(stream, onChangeListener)
    }

    override fun getValue(stream: String): T? = mStorage?.getValue(stream)

    @MainThread
    override fun set(stream: String, value: T?) {
        mStorage?.setValue(stream, value)
    }

    @SuppressLint("RestrictedApi")
    override fun post(stream: String, value: T?) {
        var postTask: Boolean
        synchronized(mDataLock) {
            postTask = mPendingValue == UNSET
            mPendingKey = stream
            mPendingValue = value
        }

        if (!postTask) {
            return
        }

        ArchTaskExecutor.getInstance().postToMainThread(mPostRunnable)
    }

    override fun unsubscribe(observer: StreamObserver<T>) {
        mStorage?.removeListener(observer.stream, observer.onChangeListener)
    }

    interface OnChangeListener<T> {
        fun onChange(value: T?)
    }

    companion object {
        private val UNSET = Any()
    }
}