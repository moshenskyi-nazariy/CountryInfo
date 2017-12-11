package com.example.nazarii_moshenskyi.cityinfo.show_cities;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.remote.CityService;
import com.example.nazarii_moshenskyi.cityinfo.data.remote.ServiceFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CityPresenter implements ICityPresenter {
    private final Context context;
    private RecyclerView cityList;
    private CityAdapter adapter;
    private CityService service;
    private List<Country> countries = new ArrayList<>();

    public CityPresenter(Context context) {
        this.context = context;
    }

    public void setList(RecyclerView cityList) {
        this.cityList = cityList;
    }

    @Override
    public Observable<String> getOnItemClickListner() {
        return adapter.getOnClickListener();
    }

    @Override
    public void start() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        List<String> data = Arrays.asList(context.getResources().getStringArray(R.array.cities));

        getData();
        adapter = new CityAdapter(context, countries);

        cityList.setLayoutManager(layoutManager);
        cityList.setAdapter(adapter);
        cityList.setItemAnimator(new DefaultItemAnimator());
    }

    private void getData() {
        service = ServiceFactory.getService();
        service.getCountries().enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                countries = response.body();
                System.out.println(countries);
                System.out.println(call.request().url());
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
