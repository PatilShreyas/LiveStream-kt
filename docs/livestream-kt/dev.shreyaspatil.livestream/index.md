[livestream-kt](../index.md) / [dev.shreyaspatil.livestream](./index.md)

## Package dev.shreyaspatil.livestream

### Types

| Name | Summary |
|---|---|
| [LiveStream](-live-stream/index.md) | LiveStream is a data holder class which can be created and used anywhere in application. By using it, You can emit values to any stream with generic data from anywhere in the application. Observers will receive data events when the value of subscribed stream is updated. This class is designed to share data between different modules in your application.`class LiveStream<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> : ILiveStream<T>` |
| [StreamObserver](-stream-observer/index.md) | A data class which stores information of subscriber and stream. Reference is useful to unsubscribe from stream.`class StreamObserver<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>` |
