package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.base.BaseMvpView;

public interface MainMvpView extends BaseMvpView {

    void writeToFile(String data);

    void noDataFound();

    String getName();

    String getPhone();

    String getAddress();

}
