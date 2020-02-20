---
title: LiveStream.set - livestream-kt
---

[livestream-kt](../../index.html) / [dev.shreyaspatil.livestream](../index.html) / [LiveStream](index.html) / [set](./set.html)

# set

`@MainThread fun set(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Sets the value. If there are active subscribers, the value will be dispatched to them.
This method must be called from the main thread.
If you need set a value from a background thread, you can use [post](post.html)

### Parameters

`stream` - Data stream

`value` - The new value