package com.example.nazarii_moshenskyi.cityinfo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_cities.CountryAdapter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_cities.CountryItemDecorator;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_cities.CountryPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_cities.CountryView;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryInfoActivity;

import java.util.List;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class MainActivity extends AppCompatActivity implements CountryView {
    private static final String TAG = "MainActivity";
    private CountryPresenter presenter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CountryAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(getApplicationContext());

        initList();

        presenter = new CountryPresenter(this);
        presenter.getCountries();
    }

    private void initList() {
        recyclerView = findViewById(R.id.country_list);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CountryItemDecorator((int) getResources().
                getDimension(R.dimen.margins)));

        adapter = new CountryAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onLoad(List<Country> countries) {
        adapter.update(countries);
    }

    @Override
    public void onClick(Country country) {
        Intent intent = new Intent(getApplicationContext(), CountryInfoActivity.class);
        intent.putExtra(COUNTRY_EXTRA, country.getName());
        startActivity(intent);
    }

}
