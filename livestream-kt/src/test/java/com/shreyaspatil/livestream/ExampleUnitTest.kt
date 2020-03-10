package com.shreyaspatil.livestream

import dev.shreyaspatil.livestream.LiveStream
import dev.shreyaspatil.livestream.data.DataStore
import dev.shreyaspatil.livestream.extension.subscribe
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun liveStream_isCorrectValueInCallback() {
        val stringValue1 = "Hello"
        val liveStream = LiveStream<String>()

        liveStream.subscribe("test") { stringValue2 ->
            assertEquals(stringValue1, stringValue2)
        }

        liveStream.set("test", stringValue1)
    }

    @Test
    fun dataStore_checkValues() {
        val dataStore = DataStore.getInstance<String>()

        val expected = "Hello World"

        // Listener to avoid error of tests.
        dataStore?.setListener("value", object : LiveStream.OnChangeListener<String> {
            override fun onChange(value: String?) {
                println("Value = $value")
            }
        })

        dataStore?.setValue("value", expected)

        val actual = dataStore?.getValue("value")

        assertEquals(expected, actual)
    }
}
