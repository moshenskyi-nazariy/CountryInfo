package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;

public abstract class BaseFragment<T extends BaseMvpPresenter<E>, E extends BaseMvpView> extends Fragment implements BaseMvpView {
    protected T presenter;
    protected abstract T createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((presenter = createPresenter()) == null) {
            throw new NullPointerException("Presenter shouldn't be null");
        }
        presenter.attachView((E) this);
    }

    public void registerReceiver(InternetManager manager) {
        manager.registerReceiver(getActivity());
    }

    public void unregisterReceiver(InternetManager manager) {
        manager.unregisterReceiver(getActivity());
    }

    public T getPresenter() {
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (presenter != null) {
            presenter.detachView();
        }
    }
}
