package com.shreyaspatil.livestream.extension

import com.shreyaspatil.livestream.LiveStream

@Suppress("unused")
fun <T : Any> LiveStream<T>.on(key: String, onChangeCallback: (T?) -> Unit) {
    on(key, object : LiveStream.OnChangeListener<T> {
        override fun onChange(value: T?) {
            onChangeCallback(value)
        }
    })
}