package com.nazarii_moshenskyi.countryinfo.ui.main.presenter;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;
import com.nazarii_moshenskyi.countryinfo.ui.base.BaseMvpPresenter;
import com.nazarii_moshenskyi.countryinfo.ui.main.view.MainMvpView;

public interface MainMvpPresenter extends BaseMvpPresenter<MainMvpView> {

    void onItemClicked(Country country);

    void defineLayout();

    void onStop();

}
