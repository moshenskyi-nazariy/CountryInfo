package com.example.nazarii_moshenskyi.cityinfo.show_cities;

import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.BasePresenter;
import com.example.nazarii_moshenskyi.cityinfo.data.IRepository;

import io.reactivex.Observable;

public interface ICityPresenter extends BasePresenter {

    void setList(RecyclerView cityList);

    void  setRepository(IRepository repository);

    Observable<String> getOnItemClickListener();

}
