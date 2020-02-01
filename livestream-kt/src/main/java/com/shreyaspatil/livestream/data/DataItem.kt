package com.shreyaspatil.livestream.data

import com.shreyaspatil.livestream.LiveStream

data class DataItem<T>(
    var value: T? = null,
    var onChangeListener: MutableList<LiveStream.OnChangeListener<T>>? = null
)