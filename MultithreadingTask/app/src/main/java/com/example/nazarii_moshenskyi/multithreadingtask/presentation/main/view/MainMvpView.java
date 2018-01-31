package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.view;

import com.example.nazarii_moshenskyi.multithreadingtask.presentation.base.BaseMvpView;

import java.io.IOException;

public interface MainMvpView extends BaseMvpView {

    void writeToFile(String data);

    void noDataFound();

    void showLoading();

    void hideLoading();

    void readData();

    void fillFields(String[] data);
}
