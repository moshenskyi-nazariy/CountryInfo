package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

public class RxBasePresenter<T extends BaseMvpView> extends BasePresenter<T> {
    private final CompositeDisposable compositeDisposable;
    private static final String TAG = "RxBasePresenter";

    @Inject
    public RxBasePresenter(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void detachView() {
        super.detachView();
        compositeDisposable.dispose();
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
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
