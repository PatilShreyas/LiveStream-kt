[livestream-kt](../../index.md) / [dev.shreyaspatil.livestream](../index.md) / [LiveStream](index.md) / [subscribe](./subscribe.md)

# subscribe

`fun subscribe(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeListener: OnChangeListener<T>): `[`StreamObserver`](../-stream-observer/index.md)`<T>`

Subscribes to the given stream. The events are dispatched on the main thread.
If stream already has data set, it will be delivered to the listener.
You should call [unsubscribe](unsubscribe.md) to stop observing LiveStream.

### Parameters

`stream` - Data stream.

`onChangeListener` - The observer which will receive the events.

**Return**
[StreamObserver](../-stream-observer/index.md) Reference will be useful when you'll need to call a
method [unsubscribe](unsubscribe.md).

