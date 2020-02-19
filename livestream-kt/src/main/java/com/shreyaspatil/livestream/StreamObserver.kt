package com.shreyaspatil.livestream

class StreamObserver<T : Any> internal constructor(
    val stream: String,
    internal val onChangeListener: LiveStream.OnChangeListener<T>
) {
}