package com.example.nazarii_moshenskyi.cityinfo.show_cities;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.data.IRepository;
import com.example.nazarii_moshenskyi.cityinfo.data.LocalGsonRepository;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryList;

import io.reactivex.Observable;

public class CityPresenter implements ICityPresenter {
    private final Context context;
    private RecyclerView cityList;
    private CityAdapter adapter;
    private CountryList countries;

    private IRepository repository;

    public CityPresenter(Context context) {
        this.context = context;
    }

    public void setList(RecyclerView cityList) {
        this.cityList = cityList;
    }

    @Override
    public Observable<String> getOnItemClickListener() {
        return adapter.getOnClickListener();
    }

    @Override
    public void start() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        //List<String> data = Arrays.asList(context.getResources().getStringArray(R.array.cities));

        getData();
        adapter = new CityAdapter(countries.getCountries());

        cityList.setLayoutManager(layoutManager);
        cityList.setAdapter(adapter);
        cityList.setItemAnimator(new DefaultItemAnimator());
    }

    private void getData() {
        //CityService service = ServiceFactory.getService();
        repository = new LocalGsonRepository(context);

        countries = (CountryList) repository.getCountries();
    }

    public void setRepository(IRepository repository) {
        this.repository = repository;
    }

}
