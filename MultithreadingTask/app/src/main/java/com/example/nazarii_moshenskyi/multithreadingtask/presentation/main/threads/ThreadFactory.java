package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.threads;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.listener.OnDataLoadedListener;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.listener.OnDataReadyListener;

public class ThreadFactory {
    public static AsyncTaskDataLoader createAsyncTask(OnDataLoadedListener loadedListener, OnDataReadyListener readyListener) {
        return new AsyncTaskDataLoader(loadedListener, readyListener);
    }
}
