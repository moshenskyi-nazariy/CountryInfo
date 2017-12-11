package com.example.nazarii_moshenskyi.cityinfo.data;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.remote.CityService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRepository implements IRepository {
    private CityService service;
    private List<Country> countries;

    public NetworkRepository(CityService service) {
        this.service = service;
    }

    public List<Country> getCountries() {
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

        return countries;
    }
}
