---
title: dev.shreyaspatil.livestream.extension - livestream-kt
---

[livestream-kt](../index.html) / [dev.shreyaspatil.livestream.extension](./index.html)

## Package dev.shreyaspatil.livestream.extension

### Functions

| [subscribe](subscribe.html) | Subscribes to the given stream. The events are dispatched on the main thread. If stream already has data set, it will be delivered to the listener. You should call [LiveStream.unsubscribe](../dev.shreyaspatil.livestream/-live-stream/unsubscribe.html) to stop observing LiveStream.`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LiveStream`](../dev.shreyaspatil.livestream/-live-stream/index.html)`<T>.subscribe(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeCallback: (T?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StreamObserver`](../dev.shreyaspatil.livestream/-stream-observer/index.html)`<T>` |

