package com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads;

import android.os.AsyncTask;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.view.MainMvpView;


public class AsyncTaskDataLoader extends AsyncTask<String, Integer, String> {
    private final MainMvpView readyListener;

    public AsyncTaskDataLoader(MainMvpView readyListener) {
        this.readyListener = readyListener;
    }

    @Override
    protected String doInBackground(String... strings) {
        readyListener.writeToFile(strings[0]);
        return strings[0];
    }

}
