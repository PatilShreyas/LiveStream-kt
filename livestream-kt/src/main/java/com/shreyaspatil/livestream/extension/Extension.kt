package com.shreyaspatil.livestream.extension

import androidx.lifecycle.LifecycleObserver
import com.shreyaspatil.livestream.LiveStream

@Suppress("unused")
fun <T : Any> LiveStream<T>.on(
    key: String,
    owner: LifecycleObserver?,
    onChangeCallback: (T?) -> Unit
) {
    on(key, owner, object : LiveStream.OnChangeListener<T> {
        override fun onChange(value: T?) {
            onChangeCallback(value)
        }
    })
}