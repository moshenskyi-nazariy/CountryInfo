package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.presenter;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.MainMvpView;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads.AsyncTaskDataLoader;
import com.example.nazarii_moshenskyi.multithreadingtask.presentation.threads.ThreadFactory;

public class MainPresenter implements MainMvpPresenter, AsyncTaskDataLoader.OnDataReadyListener {
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
    public void runAsyncTask() {
        String[] data = prepareData();
        if (isValid(data)) {
            data = transformData();
            AsyncTaskDataLoader asyncTask = ThreadFactory.createAsyncTask(this);
            asyncTask.execute(data);
        } else {
            view.noDataFound();
        }
    }

    private String[] prepareData() {
        return new String[]{view.getName()
                , view.getPhone()
                , view.getAddress()};
    }

    private String[] transformData() {
        return new String[]{"name: " + view.getName() + "\n"
                , "phone: " + view.getPhone() + "\n"
                , "email:" + view.getAddress() + "\n"};
    }

    private boolean isValid(String[] data) {
        for(String item : data) {
            if (item.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void runLoader() {

    }

    @Override
    public void runHandlerThread() {

    }

    @Override
    public void writeToFile(String data) {
        view.writeToFile(data);
    }
}
