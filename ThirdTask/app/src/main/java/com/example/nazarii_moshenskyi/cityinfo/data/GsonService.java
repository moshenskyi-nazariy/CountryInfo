package com.example.nazarii_moshenskyi.cityinfo.data;

import android.content.Context;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryList;
import com.example.nazarii_moshenskyi.cityinfo.utils.CountryDeserializer;
import com.example.nazarii_moshenskyi.cityinfo.utils.CountryListDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;

public class GsonService {
    private Context context;

    public GsonService(Context context) {
        this.context = context;
    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("countriesToCities.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        context = null;
        return json;
    }

    public CountryList getCountries() {
        String json = loadJSONFromAsset();
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