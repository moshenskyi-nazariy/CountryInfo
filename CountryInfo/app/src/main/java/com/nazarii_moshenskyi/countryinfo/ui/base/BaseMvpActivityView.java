package com.nazarii_moshenskyi.countryinfo.ui.base;

import com.nazarii_moshenskyi.countryinfo.ui.InternetManager;

public interface BaseMvpActivityView extends BaseMvpView {

    void registerReceiver(InternetManager internetManager);

    void unregisterReceiver(InternetManager internetManager);

}
