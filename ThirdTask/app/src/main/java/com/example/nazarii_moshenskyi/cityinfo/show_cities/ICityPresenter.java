package com.example.nazarii_moshenskyi.cityinfo.show_cities;

import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.BasePresenter;

import io.reactivex.Observable;

public interface ICityPresenter extends BasePresenter {

    void setList(RecyclerView cityList);

    Observable<String> getOnItemClickListner();

}
