[livestream-kt](../../index.md) / [dev.shreyaspatil.livestream](../index.md) / [LiveStream](./index.md)

# LiveStream

`class LiveStream<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : ILiveStream<T>`

LiveStream is a data holder class which can be created and used anywhere in application.
By using it, You can emit values to any stream with generic data from anywhere in the application.
Observers will receive data events when the value of subscribed stream is updated.
This class is designed to share data between different modules in your application.

### Parameters

`T` - The type of a data.

### Types

| Name | Summary |
|---|---|
| [OnChangeListener](-on-change-listener/index.md) | A simple callback that can retrieve from [LiveStream](./index.md).`interface OnChangeListener<T>` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | LiveStream is a data holder class which can be created and used anywhere in application. By using it, You can emit values to any stream with generic data from anywhere in the application. Observers will receive data events when the value of subscribed stream is updated. This class is designed to share data between different modules in your application.`LiveStream()` |

### Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | Returns the current value of a stream. Note that calling this method on a background thread does not guarantee that the latest value set will be received.`fun getValue(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): T?` |
| [post](post.md) | Posts a task to main thread to set the given value. This method should be called from background thread. Otherwise, you can use [set](set.md) If there are active subscribers, the value will be dispatched to them.`fun post(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [set](set.md) | Sets the value. If there are active subscribers, the value will be dispatched to them. This method must be called from the main thread. If you need set a value from a background thread, you can use [post](post.md)`fun set(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribe](subscribe.md) | Subscribes to the given stream. The events are dispatched on the main thread. If stream already has data set, it will be delivered to the listener. You should call [unsubscribe](unsubscribe.md) to stop observing LiveStream.`fun subscribe(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeListener: OnChangeListener<T>): `[`StreamObserver`](../-stream-observer/index.md)`<T>` |
| [unsubscribe](unsubscribe.md) | Removes/unsubscribe the given stream observer.`fun unsubscribe(observer: `[`StreamObserver`](../-stream-observer/index.md)`<T>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [subscribe](../../dev.shreyaspatil.livestream.extension/subscribe.md) | Subscribes to the given stream. The events are dispatched on the main thread. If stream already has data set, it will be delivered to the listener. You should call [LiveStream.unsubscribe](unsubscribe.md) to stop observing LiveStream.`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`LiveStream`](./index.md)`<T>.subscribe(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeCallback: (T?) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`StreamObserver`](../-stream-observer/index.md)`<T>` |
