package com.shreyaspatil.livestream

internal interface ILiveStream<T> {
    fun emit(key: String, value: T?)
    fun on(
        key: String,
        onChangeListener: LiveStream.OnChangeListener<T>?
    )

    fun getValue(key: String): T?
}