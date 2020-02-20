---
title: LiveStream.subscribe - livestream-kt
---

[livestream-kt](../../index.html) / [dev.shreyaspatil.livestream](../index.html) / [LiveStream](index.html) / [subscribe](./subscribe.html)

# subscribe

`fun subscribe(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeListener: OnChangeListener<T>): `[`StreamObserver`](../-stream-observer/index.html)`<T>`

Subscribes to the given stream. The events are dispatched on the main thread.
If stream already has data set, it will be delivered to the listener.
You should call [unsubscribe](unsubscribe.html) to stop observing LiveStream.

### Parameters

`stream` - Data stream.

`onChangeListener` - The observer which will receive the events.

**Return**
[StreamObserver](../-stream-observer/index.html) Reference will be useful when you'll need to call a
method [unsubscribe](unsubscribe.html).

