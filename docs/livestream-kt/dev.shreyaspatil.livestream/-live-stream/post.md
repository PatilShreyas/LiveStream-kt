---
title: LiveStream.post - livestream-kt
---

[livestream-kt](../../index.html) / [dev.shreyaspatil.livestream](../index.html) / [LiveStream](index.html) / [post](./post.html)

# post

`fun post(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Posts a task to main thread to set the given value.
This method should be called from background thread. Otherwise, you can use [set](set.html)
If there are active subscribers, the value will be dispatched to them.

### Parameters

`stream` - Data stream

`value` - The new value