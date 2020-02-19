package com.shreyaspatil.livestream.example.kotlin

import dev.shreyaspatil.livestream.LiveStream
import kotlinx.coroutines.*

class AsyncProcessor {
    private val liveStream = LiveStream<String>()

    fun execute() {
        // Emit value from main thread
        CoroutineScope(Dispatchers.Main).launch {
            val asyncTask = async{ asyncTask() }
            val response = asyncTask.await()

            // Emit network response.
            liveStream.set("response", response)
        }

    }

    fun executeInBackground() {
        // Create thread and emit value from another thread
        Thread(Runnable {
            liveStream.post("response", "Hello from Other thread")
        }).start()
    }

    private suspend fun asyncTask(): String = coroutineScope {
        // Consider this block as a network call
        // Wait for some seconds
        delay(2000)

        // After some interval, store network response in result.
        val result = "Hi there! This is response from async function."
        result
    }
}
