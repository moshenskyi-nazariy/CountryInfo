package com.example.nazarii_moshenskyi.multithreadingtask.presentation.main.listener;

public interface OnDataLoadedListener {

    void showProgressBar();

    void hideProgressBar();

    void updateProgress(int progress);

}
