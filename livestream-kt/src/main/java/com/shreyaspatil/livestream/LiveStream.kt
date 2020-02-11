package com.shreyaspatil.livestream

import android.annotation.SuppressLint
import androidx.annotation.MainThread
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.lifecycle.LifecycleObserver
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

    // TODO Lifecycle

    override fun on(
        key: String,
        owner: LifecycleObserver?,
        onChangeListener: OnChangeListener<T>?
    ) {
        mStorage?.setListener(key, onChangeListener)
    }

    override fun getValue(key: String): T? = mStorage?.getValue(key)

    @MainThread
    override fun set(key: String, value: T?) {
        mStorage?.setValue(key, value)
    }

    @SuppressLint("RestrictedApi")
    override fun post(key: String, value: T?) {
        var postTask: Boolean
        synchronized(mDataLock) {
            postTask = mPendingValue == UNSET
            mPendingKey = key
            mPendingValue = value
        }

        if (!postTask) {
            return
        }

        ArchTaskExecutor.getInstance().postToMainThread(mPostRunnable)
    }

    interface OnChangeListener<T> {
        fun onChange(value: T?)
    }

    companion object {
        private val UNSET = Any()
    }
}