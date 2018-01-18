package com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads;

import android.os.AsyncTask;


public class AsyncTaskDataLoader extends AsyncTask<String, Integer, String[]> {
    private final OnDataReadyListener readyListener;

    AsyncTaskDataLoader(OnDataReadyListener readyListener) {
        this.readyListener = readyListener;
    }

    @Override
    protected String[] doInBackground(String... strings) {
        for (String string : strings) {
            readyListener.writeToFile(string);
        }
        return strings;
    }

    public interface OnDataReadyListener {

        void writeToFile(String data);

    }

}
