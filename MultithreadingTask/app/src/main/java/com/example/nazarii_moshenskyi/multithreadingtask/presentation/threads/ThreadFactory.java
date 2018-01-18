package com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads;


public class ThreadFactory {
    public static AsyncTaskDataLoader createAsyncTask(AsyncTaskDataLoader.OnDataReadyListener readyListener) {
        return new AsyncTaskDataLoader(readyListener);
    }
}
