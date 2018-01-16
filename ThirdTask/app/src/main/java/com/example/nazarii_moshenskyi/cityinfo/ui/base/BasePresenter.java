package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import android.util.Log;

import java.io.IOException;

import retrofit2.HttpException;

public abstract class BasePresenter<T extends BaseMvpView> implements BaseMvpPresenter<T> {
    private T view;
    private static final String TAG = "BasePresenter";

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }

    protected T getView() {
        return view;
    }

    protected void handleError(Throwable throwable) {
        if (throwable instanceof HttpException) {
            Log.d(TAG, "handleError: Non-2XX exception(" + throwable.getClass() + "):" + throwable.getMessage());
        } else if (throwable instanceof IOException) {
            Log.d(TAG, "handleError: Network error(" + throwable.getClass() + "):" + throwable.getMessage());
        } else {
            Log.d(TAG, "handleError: " + throwable.getClass() + "):" + throwable.getMessage());
        }
    }

}
