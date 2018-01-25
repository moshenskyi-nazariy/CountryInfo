package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends  BaseMvpPresenter<E>, E extends BaseMvpView> extends AppCompatActivity implements BaseMvpView {
    protected T presenter;

    protected abstract T createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = (T) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            if ((presenter = createPresenter()) == null) {
                throw new NullPointerException("Presenter shouldn't be null");
            }
        }
        presenter.attachView((E) this);
    }

    public T getPresenter() {
        return presenter;
    }

    @Override
    public final Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}