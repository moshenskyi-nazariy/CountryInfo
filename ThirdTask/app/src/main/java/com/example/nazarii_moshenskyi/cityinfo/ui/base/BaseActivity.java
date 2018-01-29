package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;

public abstract class BaseActivity<T extends  BaseMvpPresenter<E>, E extends BaseMvpActivityView> extends AppCompatActivity implements BaseMvpActivityView {
    protected T presenter;

    protected abstract T createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (presenter == null) {
            if ((presenter = createPresenter()) == null) {
                throw new NullPointerException("Presenter shouldn't be null");
            }
        }
        presenter.attachView((E) this);
    }

    public void registerReceiver(InternetManager manager) {
        manager.registerReceiver(this);
    }

    public void unregisterReceiver(InternetManager manager) {
        manager.unregisterReceiver(this);
    }

    public T getPresenter() {
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