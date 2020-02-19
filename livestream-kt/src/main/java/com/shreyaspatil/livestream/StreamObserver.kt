package com.shreyaspatil.livestream

/**
 * A data class which stores information of subscriber and stream.
 * Reference is useful to unsubscribe from stream.
 *
 * @property stream The data stream to which subscriber is observing.
 * @see LiveStream for usage.
 */
class StreamObserver<T : Any> internal constructor(
    val stream: String,
    internal val onChangeListener: LiveStream.OnChangeListener<T>
)