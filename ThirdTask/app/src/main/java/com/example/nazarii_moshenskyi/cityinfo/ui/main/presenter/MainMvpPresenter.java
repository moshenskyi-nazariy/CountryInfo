package com.example.nazarii_moshenskyi.cityinfo.ui.main.presenter;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.main.view.MainMvpView;

public interface MainMvpPresenter extends BaseMvpPresenter<MainMvpView> {

    void onItemClicked(Country country);

    void defineLayout();

    void onStop();

}
