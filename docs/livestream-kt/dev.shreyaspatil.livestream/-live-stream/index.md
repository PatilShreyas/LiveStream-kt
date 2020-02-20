---
title: LiveStream - livestream-kt
---

[livestream-kt](../../index.html) / [dev.shreyaspatil.livestream](../index.html) / [LiveStream](./index.html)

# LiveStream

`class LiveStream<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : ILiveStream<T>`

LiveStream is a data holder class which can be created and used anywhere in application.
By using it, You can emit values to any stream with generic data from anywhere in the application.
Observers will receive data events when the value of subscribed stream is updated.
This class is designed to share data between different modules in your application.

### Parameters

`T` - The type of a data.

### Types

| [OnChangeListener](-on-change-listener/index.html) | A simple callback that can retrieve from [LiveStream](./index.html).`interface OnChangeListener<T>` |

### Constructors

| [&lt;init&gt;](-init-.html) | LiveStream is a data holder class which can be created and used anywhere in application. By using it, You can emit values to any stream with generic data from anywhere in the application. Observers will receive data events when the value of subscribed stream is updated. This class is designed to share data between different modules in your application.`LiveStream()` |

### Functions

| [getValue](get-value.html) | Returns the current value of a stream. Note that calling this method on a background thread does not guarantee that the latest value set will be received.`fun getValue(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): T?` |
| [post](post.html) | Posts a task to main thread to set the given value. This method should be called from background thread. Otherwise, you can use [set](set.html) If there are active subscribers, the value will be dispatched to them.`fun post(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [set](set.html) | Sets the value. If there are active subscribers, the value will be dispatched to them. This method must be called from the main thread. If you need set a value from a background thread, you can use [post](post.html)`fun set(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribe](subscribe.html) | Subscribes to the given stream. The events are dispatched on the main thread. If stream already has data set, it will be delivered to the listener. You should call [unsubscribe](unsubscribe.html) to stop observing LiveStream.`fun subscribe(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeListener: OnChangeListener<T>): `[`StreamObserver`](../-stream-observer/index.html)`<T>` |
| [unsubscribe](unsubscribe.html) | Removes/unsubscribe the given stream observer.`fun unsubscribe(observer: `[`StreamObserver`](../-stream-observer/index.html)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| [subscribe](../../dev.shreyaspatil.livestream.extension/subscribe.html) | Subscribes to the given stream. The events are dispatched on the main thread. If stream already has data set, it will be delivered to the listener. You should call [LiveStream.unsubscribe](unsubscribe.html) to stop observing LiveStream.`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LiveStream`](./index.html)`<T>.subscribe(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeCallback: (T?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StreamObserver`](../-stream-observer/index.html)`<T>` |

