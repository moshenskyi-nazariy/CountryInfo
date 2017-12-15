package com.example.nazarii_moshenskyi.cityinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.data.GsonService;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryList;
import com.example.nazarii_moshenskyi.cityinfo.show_cities.CityAdapter;
import com.example.nazarii_moshenskyi.cityinfo.show_cities.CityItemDecorator;
import com.example.nazarii_moshenskyi.cityinfo.show_cities.CityPresenter;

public class MainActivity extends AppCompatActivity implements BaseView {
    private static final String TAG = "MainActivity";
    private CityPresenter presenter;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.country_list);

        GsonService gsonService = new GsonService(getApplicationContext());

        presenter = new CityPresenter(this, gsonService);
        presenter.getCountryList();
    }

    @Override
    public void onLoad(CountryList countries) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        CityAdapter adapter = new CityAdapter(countries.getCountries());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CityItemDecorator((int) getResources().getDimension(R.dimen.margins)));
    }

}
