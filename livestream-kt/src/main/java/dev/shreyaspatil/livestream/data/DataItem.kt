package dev.shreyaspatil.livestream.data

import dev.shreyaspatil.livestream.LiveStream

data class DataItem<T>(
    var value: T? = null,
    var onChangeListener: MutableList<LiveStream.OnChangeListener<T>>? = null
)