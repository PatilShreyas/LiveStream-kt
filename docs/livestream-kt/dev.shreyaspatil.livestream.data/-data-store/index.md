---
title: DataStore - livestream-kt
---

[livestream-kt](../../index.html) / [dev.shreyaspatil.livestream.data](../index.html) / [DataStore](./index.html)

# DataStore

`class DataStore<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

### Functions

| [getValue](get-value.html) | Returns the current value of given data stream.`fun getValue(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): T?` |
| [removeListener](remove-listener.html) | Removes the given listener from the data stream.`fun removeListener(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeListener: OnChangeListener<T>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setListener](set-listener.html) | Subscribes observer to the given stream.`fun setListener(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, listener: OnChangeListener<T>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setValue](set-value.html) | Sets the given value to the stream (key).`fun setValue(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| [getInstance](get-instance.html) | Returns singleton instance of [DataStore](./index.html)`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getInstance(): `[`DataStore`](./index.html)`<T>?` |

