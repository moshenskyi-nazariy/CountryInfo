package com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class FileHandlerThread extends HandlerThread {
    private Handler handler;

    public FileHandlerThread(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        handler = new Handler(getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
    }
}
