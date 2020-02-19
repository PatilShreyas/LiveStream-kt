package com.shreyaspatil.livestream.example.java;

import dev.shreyaspatil.livestream.LiveStream;

public class AsyncProcessor {

    private LiveStream<String> liveStream = new LiveStream<>();

    public void execute() {
        delay();
        liveStream.set("response", "Hi! Response from main thread");
    }

    public void executeInBackground() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                delay();
                liveStream.post("response", "Hi! Response from other thread");
            }
        }).start();
    }

    public void delay() {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {
        }
    }
}
