package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import android.support.v4.app.Fragment;

import javax.inject.Inject;

public class BaseFragment<T extends BaseMvpPresenter> extends Fragment {
    @Inject
    protected T presenter;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
