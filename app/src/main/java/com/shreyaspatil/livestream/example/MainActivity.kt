package com.shreyaspatil.livestream.example

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shreyaspatil.livestream.LiveStream
import com.shreyaspatil.livestream.extension.on
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val liveStream = LiveStream<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize LiveStream instance
        initLiveStream()

        button_execute.setOnClickListener {
            // Execute background task
//            AsyncProcessor().execute()
            AsyncProcessor().otherThreadExecute()
        }
    }

    private fun initLiveStream() {
        // Subscribe to 'response' stream using on() method.
        // Whenever value is emitted to 'response' stream,
        // below block is executed.

        liveStream.on("response", null) { response ->
            Log.w("TESTING_RESPONSE", response)
            showToast(response)
        }
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
