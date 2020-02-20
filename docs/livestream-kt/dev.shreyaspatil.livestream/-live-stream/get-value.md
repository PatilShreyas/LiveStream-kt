---
title: LiveStream.getValue - livestream-kt
---

[livestream-kt](../../index.html) / [dev.shreyaspatil.livestream](../index.html) / [LiveStream](index.html) / [getValue](./get-value.html)

# getValue

`fun getValue(stream: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): T?`

Returns the current value of a stream. Note that calling this method on a background thread
does not guarantee that the latest value set will be received.

### Parameters

`stream` - Data stream

**Return**
The current value of a [stream](get-value.html#dev.shreyaspatil.livestream.LiveStream$getValue(kotlin.String)/stream)

