package com.example.nazarii_moshenskyi.thirdtask.show_cities;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.thirdtask.BasePresenter;
import com.example.nazarii_moshenskyi.thirdtask.R;

import java.util.Arrays;
import java.util.List;

public class CityPresenter implements BasePresenter {
    private final Context context;
    private RecyclerView cityList;

    public CityPresenter(Context context, RecyclerView cityList) {
        this.cityList = cityList;
        this.context = context;
    }

    @Override
    public void start() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        List<String> data = Arrays.asList(context.getResources().getStringArray(R.array.cities));

        cityList.setLayoutManager(layoutManager);
        cityList.setAdapter(new CityAdapter(context, data));
        cityList.setItemAnimator(new DefaultItemAnimator());
    }
}
