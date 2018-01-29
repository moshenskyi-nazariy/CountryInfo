package com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads;

import android.os.Handler;
import android.os.HandlerThread;

public class FileHandlerThread extends HandlerThread {
    private Handler handler;
    private static final String TAG = "FileHandlerThread";

    public FileHandlerThread(String name) {
        super(name);
    }

    public void prepareHandler() {
        handler = new Handler(getLooper());
    }

    public void postTask(Runnable task) {
        handler.post(task);
    }

}
