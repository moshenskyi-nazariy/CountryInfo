package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;
import com.example.nazarii_moshenskyi.cityinfo.ui.util.RxUtils;

import javax.inject.Inject;

import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.CompositeDisposable;

public class RxBasePresenter<T extends BaseRxMvpView, V> extends BasePresenter<T> {
    private final CompositeDisposable compositeDisposable;
    private static final String TAG = "RxBasePresenter";

    @Inject
    public RxBasePresenter(CompositeDisposable compositeDisposable, InternetManager manager) {
        super(manager);
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void detachView() {
        super.detachView();
        compositeDisposable.clear();
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    protected void handleError(Throwable throwable) {
        //getView().hideLoadingBar();
    }

    protected ObservableTransformer<V, V> getProgressTransformer() {
        return RxUtils.applyProgressOnservable(disposable -> {
            if (getView() != null) {
                getView().showLoadingBar();
            }
        }, () -> {
            if (getView() != null) {
                getView().showLoadingBar();
            }
        });
    }
}
