package com.shreyaspatil.livestream.data

import android.util.Log
import com.shreyaspatil.livestream.LiveStream
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DataStore<T : Any> private constructor() {
    private val mDataItemsMap: MutableMap<String, DataItem<T>> = HashMap()

    fun setValue(key: String, value: T?) {
        var item = mDataItemsMap[key]
        if (item == null) {
            item = DataItem()
        }
        item.value = value
        mDataItemsMap[key] = item
        val listeners: List<LiveStream.OnChangeListener<T>>? = item.onChangeListener

        listeners?.let {
            synchronized(it) {
                for (listener in it) {
                    try {
                        listener.onChange(item.value)
                    } catch (e: ClassCastException) {
                        // Value is not able to cast.
                        logError(e)
                    }
                }
            }
        }

        if (listeners == null) {
            logWarning("No Subscriber is registered to listen Updates. Use LiveStream#on() method to subscribe.")
        }
    }

    fun setListener(key: String, listener: LiveStream.OnChangeListener<T>?) {
        listener?.let { onChangeListener ->
            var item = mDataItemsMap[key]
            if (item == null) {
                item = DataItem()
            }

            var listeners = item.onChangeListener
            if (listeners == null) {
                listeners =
                    Collections.synchronizedList(ArrayList<LiveStream.OnChangeListener<T>>())
                item.onChangeListener = listeners
                mDataItemsMap[key] = item
            }
            listeners?.add(onChangeListener)
        }
    }

    fun getValue(key: String): T? {
        return mDataItemsMap[key]?.value
    }

    fun removeListener(key: String, onChangeListener: LiveStream.OnChangeListener<T>?) {
        mDataItemsMap[key]?.onChangeListener?.remove(onChangeListener)
    }

    private fun logError(e: Exception) {
        Log.e(javaClass.simpleName, e.message, e)
    }

    private fun logWarning(message: String) {
        Log.w(javaClass.simpleName, message)
    }

    companion object {
        private var INSTANCE: DataStore<*>? = null
        @JvmStatic
        @Synchronized
        fun <T : Any> getInstance(): DataStore<T>? {
            if (INSTANCE == null) {
                INSTANCE =
                    DataStore<T>()
            }
            return INSTANCE as DataStore<T>?
        }
    }
}