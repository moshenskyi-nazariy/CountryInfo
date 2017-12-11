package com.example.nazarii_moshenskyi.cityinfo.data;

import android.content.Context;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryList;
import com.example.nazarii_moshenskyi.cityinfo.utils.CountryDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.utils.CountryListDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.Comparator;


public class LocalGsonRepository implements IRepository<CountryList> {
    private Context context;
    private GsonService service;
    private String json;

    public LocalGsonRepository(Context context) {
        this.context = context;
    }

    @Override
    public CountryList getCountries() {
        service = new GsonService(context);
        json = service.loadJSONFromAsset();
        Gson gson = new GsonBuilder().
                registerTypeAdapter(CountryList.class, new CountryListDeserializer()).
                registerTypeAdapter(Country.class, new CountryDeserializer()).
                create();

        context = null;
        CountryList list = gson.fromJson(json, CountryList.class);
        Collections.sort(list.getCountries(), new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        return list;
    }

}
