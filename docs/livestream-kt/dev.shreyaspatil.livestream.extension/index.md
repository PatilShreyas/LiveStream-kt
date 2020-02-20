[livestream-kt](../index.md) / [dev.shreyaspatil.livestream.extension](./index.md)

## Package dev.shreyaspatil.livestream.extension

### Functions

| Name | Summary |
|---|---|
| [subscribe](subscribe.md) | Subscribes to the given stream. The events are dispatched on the main thread. If stream already has data set, it will be delivered to the listener. You should call [LiveStream.unsubscribe](../dev.shreyaspatil.livestream/-live-stream/unsubscribe.md) to stop observing LiveStream.`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LiveStream`](../dev.shreyaspatil.livestream/-live-stream/index.md)`<T>.subscribe(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeCallback: (T?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StreamObserver`](../dev.shreyaspatil.livestream/-stream-observer/index.md)`<T>` |
