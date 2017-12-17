package com.example.nazarii_moshenskyi.cityinfo.ui;

import io.reactivex.Observable;

public interface BaseView<T> {

    void onLoad(Observable<T> items);

}
