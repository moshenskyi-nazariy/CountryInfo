package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;

import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

public class RxBasePresenter<T extends BaseRxMvpView> extends BasePresenter<T> {
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
        getView().hideLoadingBar();
    }
}
