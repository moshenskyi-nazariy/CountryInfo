package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.threads;

import android.os.AsyncTask;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.listener.OnDataLoadedListener;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.listener.OnDataReadyListener;


public class AsyncTaskDataLoader extends AsyncTask<String, Integer, String[]> {
    private final OnDataLoadedListener loaderListener;
    private final OnDataReadyListener readyListener;

    AsyncTaskDataLoader(OnDataLoadedListener loaderListener, OnDataReadyListener readyListener) {
        this.loaderListener = loaderListener;
        this.readyListener = readyListener;
    }

    @Override
    protected String[] doInBackground(String... strings) {
        int count = strings.length;

        for (int i = 0; i < count; i++) {
            // TODO: Load data into file.
            readyListener.writeToFile(strings[i]);
            publishProgress(i / count * 10);
        }
        return strings;
    }

    @Override
    protected void onPreExecute() {
        loaderListener.showProgressBar();
    }

    @Override
    protected void onPostExecute(String[] s) {
        loaderListener.hideProgressBar();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        loaderListener.updateProgress(values[0]);
    }
}
