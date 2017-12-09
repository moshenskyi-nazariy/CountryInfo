package com.example.nazarii_moshenskyi.thirdtask.show_cities;

import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.thirdtask.BasePresenter;

public interface ICityPresenter extends BasePresenter {

    void setList(RecyclerView cityList);

}
