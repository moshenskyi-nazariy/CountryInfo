package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public T getPresenter() {
        return presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

    }

/*    protected boolean isConnected() {
        Context context = getActivity();
        if (context != null) {

            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork.isConnectedOrConnecting();
        }

        return false;
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
