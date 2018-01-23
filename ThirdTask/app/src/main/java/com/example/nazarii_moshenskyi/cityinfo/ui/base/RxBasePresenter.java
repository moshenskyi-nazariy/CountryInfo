package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import javax.inject.Inject;
import io.reactivex.disposables.CompositeDisposable;

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
        //TODO: catch exception
    }
}
