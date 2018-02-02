package com.example.nazarii_moshenskyi.cityinfo.ui.base;

import com.example.nazarii_moshenskyi.cityinfo.ui.InternetManager;

public interface BaseMvpActivityView extends BaseMvpView {

    void registerReceiver(InternetManager internetManager);

    void unregisterReceiver(InternetManager internetManager);

}
