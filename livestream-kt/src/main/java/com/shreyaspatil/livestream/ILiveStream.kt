package com.shreyaspatil.livestream

internal interface ILiveStream<T : Any> {
    fun set(stream: String, value: T?)
    fun post(stream: String, value: T?)
    fun subscribe(
        stream: String,
        onChangeListener: LiveStream.OnChangeListener<T>
    ): StreamObserver<T>

    fun unsubscribe(observer: StreamObserver<T>)
    fun getValue(stream: String): T?
}