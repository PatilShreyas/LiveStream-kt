[livestream-kt](../../index.md) / [dev.shreyaspatil.livestream](../index.md) / [LiveStream](index.md) / [set](./set.md)

# set

`@MainThread fun set(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the value. If there are active subscribers, the value will be dispatched to them.
This method must be called from the main thread.
If you need set a value from a background thread, you can use [post](post.md)

### Parameters

`stream` - Data stream

`value` - The new value