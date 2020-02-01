package com.shreyaspatil.livestream

import com.shreyaspatil.livestream.data.DataStore

/**
 *
 */
class LiveStream<T : Any> : ILiveStream<T> {
    private val mStorage: DataStore<T>? = DataStore.getInstance()

    override fun emit(key: String, value: T?) {
        mStorage?.setValue(key, value)
    }

    override fun on(key: String, onChangeListener: OnChangeListener<T>?) {
        mStorage?.setListener(key, onChangeListener)
    }

    override fun getValue(key: String): T? = mStorage?.getValue(key)

    interface OnChangeListener<T> {
        fun onChange(value: T?)
    }
}