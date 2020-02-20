[livestream-kt](../../index.md) / [dev.shreyaspatil.livestream.data](../index.md) / [DataStore](./index.md)

# DataStore

`class DataStore<T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`>`

### Functions

| Name | Summary |
|---|---|
| [getValue](get-value.md) | Returns the current value of given data stream.`fun getValue(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): T?` |
| [removeListener](remove-listener.md) | Removes the given listener from the data stream.`fun removeListener(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, onChangeListener: OnChangeListener<T>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setListener](set-listener.md) | Subscribes observer to the given stream.`fun setListener(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, listener: OnChangeListener<T>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setValue](set-value.md) | Sets the given value to the stream (key).`fun setValue(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, value: T?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getInstance](get-instance.md) | Returns singleton instance of [DataStore](./index.md)`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> getInstance(): `[`DataStore`](./index.md)`<T>?` |
