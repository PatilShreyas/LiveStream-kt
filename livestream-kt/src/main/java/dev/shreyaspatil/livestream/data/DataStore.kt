package dev.shreyaspatil.livestream.data

import android.util.Log
import dev.shreyaspatil.livestream.LiveStream
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class DataStore<T : Any> private constructor() {

    // Mutable HashMap to hold stream (key) with data and observers.
    private val mDataItemsMap: MutableMap<String, DataItem<T>> = HashMap()

    /**
     * Sets the given value to the stream (key).
     */
    fun setValue(key: String, value: T?) {
        // Retrieve data item from the map.
        var item = mDataItemsMap[key]
        if (item == null) {
            item = DataItem()
        }

        // Set new value to the Data item.
        item.value = value

        // Reset the data item to the map.
        mDataItemsMap[key] = item

        // Retrieve all the listeners associated with the given stream to dispatch events.
        val listeners: List<LiveStream.OnChangeListener<T>>? = item.onChangeListener

        listeners?.let {
            synchronized(it) {
                for (listener in it) {
                    try {
                        // Dispatch observers
                        listener.onChange(item.value)
                    } catch (e: ClassCastException) {
                        // This might occur if subscriber's generic type is different than emitter.
                        logError(e)
                    }
                }
            }
        }

        // If stream does not have subscriber/observer then show warning.
        if (listeners == null) {
            logWarning("No Subscriber is registered to listen Updates. Use LiveStream#on() method to subscribe.")
        }
    }

    /**
     * Subscribes observer to the given stream.
     */
    fun setListener(key: String, listener: LiveStream.OnChangeListener<T>?) {
        listener?.let { onChangeListener ->
            // Retrieve data item from the map.
            var item = mDataItemsMap[key]
            if (item == null) {
                item = DataItem()
            }

            // Get all the listeners associated with the given stream (key).
            var listeners = item.onChangeListener
            if (listeners == null) {
                // If list is empty then create new one.
                // Synchronized list is useful when using it in multithreading operations.
                listeners =
                    Collections.synchronizedList(ArrayList<LiveStream.OnChangeListener<T>>())

                // Set listener to data item.
                item.onChangeListener = listeners

                // Reset the data item to the map.
                mDataItemsMap[key] = item
            }

            // Finally, add listener to the list.
            listeners?.add(onChangeListener)
        }
    }

    /**
     * Returns the current value of given data stream.
     */
    fun getValue(key: String): T? {
        return mDataItemsMap[key]?.value
    }

    /**
     * Removes the given listener from the data stream.
     */
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

        /**
         * Returns singleton instance of [DataStore]
         */
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