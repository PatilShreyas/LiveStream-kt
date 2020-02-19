package com.shreyaspatil.livestream.example

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shreyaspatil.livestream.LiveStream
import com.shreyaspatil.livestream.StreamObserver
import com.shreyaspatil.livestream.extension.subscribe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val liveStream = LiveStream<String>()
    private lateinit var observer: StreamObserver<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_exec_main.setOnClickListener {
            // Execute background task on main thread
            AsyncProcessor().execute()
        }

        button_exec_thread.setOnClickListener {
            // Execute background task on other thread
            AsyncProcessor().executeInBackground()
        }
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()

        // Subscribe to 'response' stream using subscribe() method.
        // Whenever value is emitted to 'response' stream,
        // below block is executed.

        observer = liveStream.subscribe("response") { response ->
            Log.w("TESTING_RESPONSE", response!!)
            showToast(response)
        }
    }

    override fun onStop() {
        super.onStop()
        liveStream.unsubscribe(observer)
    }
}
