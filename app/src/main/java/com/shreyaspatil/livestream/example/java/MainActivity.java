package com.shreyaspatil.livestream.example.java;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.shreyaspatil.livestream.LiveStream;
import com.shreyaspatil.livestream.StreamObserver;
import com.shreyaspatil.livestream.example.R;

public class MainActivity extends AppCompatActivity {
    private LiveStream<String> liveStream = new LiveStream<>();
    private StreamObserver<String> observer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button to execute task on Main thread
        findViewById(R.id.button_exec_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncProcessor().execute();
            }
        });

        // Button to execute task on other thread
        findViewById(R.id.button_exec_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncProcessor().executeInBackground();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        observer = liveStream.subscribe("response", new LiveStream.OnChangeListener<String>() {
            @Override
            public void onChange(String response) {
                showToast(response);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        liveStream.unsubscribe(observer);
    }
}
