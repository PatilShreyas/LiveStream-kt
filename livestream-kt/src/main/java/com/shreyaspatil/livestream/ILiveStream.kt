package com.shreyaspatil.livestream

import androidx.lifecycle.LifecycleObserver

internal interface ILiveStream<T> {
    fun set(key: String, value: T?)
    fun post(key: String, value: T?)
    fun on(
        key: String,
        owner: LifecycleObserver?,
        onChangeListener: LiveStream.OnChangeListener<T>?
    )

    fun getValue(key: String): T?
}