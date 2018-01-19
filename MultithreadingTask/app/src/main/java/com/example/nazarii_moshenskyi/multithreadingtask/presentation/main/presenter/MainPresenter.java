package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.view.MainMvpView;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads.AsyncTaskDataLoader;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads.FileHandlerThread;

public class MainPresenter implements MainMvpPresenter {
    private MainMvpView view;

    @Override
    public void attachView(MainMvpView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }

    @Override
    public void runHandlerThread(final String[] data) {
        if (isValid(data)) {
            final FileHandlerThread handlerThread = new FileHandlerThread("FileHandlerThread");
            handlerThread.start();
            handlerThread.prepareHandler();
            handlerThread.postTask(new Runnable() {
                @Override
                public void run() {
                    view.writeToFile(transformData(data));
                    handlerThread.quit();
                }
            });

        } else {
            view.noDataFound();
        }
    }

    @Override
    public void runAsyncTask(String[] data) {
        if (isValid(data)) {
            AsyncTaskDataLoader loader = new AsyncTaskDataLoader(view);
            loader.execute(transformData(data));
        } else {
            view.noDataFound();
        }
    }

    private String transformData(String[] data) {
        return new StringBuilder().append("name: ").append(data[0]).append("\n")
                .append("phone: ").append(data[1]).append("\n")
                .append("email: ").append(data[2]).append("\n").toString();
    }

    private boolean isValid(String[] data) {
        for (String item : data) {
            if (item.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
