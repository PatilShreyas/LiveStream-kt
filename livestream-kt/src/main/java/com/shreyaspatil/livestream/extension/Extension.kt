package com.shreyaspatil.livestream.extension

import com.shreyaspatil.livestream.LiveStream
import com.shreyaspatil.livestream.StreamObserver

/**
 * Subscribes to the given stream. The events are dispatched on the main thread.
 * If stream already has data set, it will be delivered to the listener.
 * You should call [LiveStream.unsubscribe] to stop observing LiveStream.
 *
 * <pre class="prettyprint">
 * val observer = liveStream.subscribe("httpResponse") { value ->
 *   println(value)
 * }
 * </pre>
 * @param stream Data stream.
 * @param onChangeCallback Unit function with the observer which will receive the events.
 * @return [StreamObserver] Reference will be useful when you'll need to call a
 * method [LiveStream.unsubscribe].
 */
@Suppress("unused")
fun <T : Any> LiveStream<T>.subscribe(
    stream: String,
    onChangeCallback: (T?) -> Unit
) = subscribe(stream, object : LiveStream.OnChangeListener<T> {
    override fun onChange(value: T?) {
        onChangeCallback(value)
    }
})