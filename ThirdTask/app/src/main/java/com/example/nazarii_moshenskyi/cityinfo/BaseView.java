package com.example.nazarii_moshenskyi.cityinfo;

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);

}
