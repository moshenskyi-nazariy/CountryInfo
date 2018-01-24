package com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads;

import android.os.AsyncTask;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.view.MainMvpView;


public class AsyncTaskDataLoader extends AsyncTask<String, Integer, String> {
    private final MainMvpView readyListener;
    private static final int DELAY = 3000;

    public AsyncTaskDataLoader(MainMvpView readyListener) {
        this.readyListener = readyListener;
    }

    @Override
    protected String doInBackground(String... strings) {
        if (readyListener != null) {
            readyListener.writeToFile(strings[0]);
        }
        return strings[0];
    }

    @Override
    protected void onPostExecute(String s) {
        readyListener.hideLoading();
    }
}
