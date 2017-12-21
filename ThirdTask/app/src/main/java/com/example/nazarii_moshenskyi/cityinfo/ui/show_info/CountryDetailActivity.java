package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.nazarii_moshenskyi.cityinfo.R;

public class CountryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        if (savedInstanceState == null) {
            //List<City> cities = getIntent().getParcelableExtra(Contract.EXTRA_CITIES);

            CountryDetailFragment fragment = CountryDetailFragment.newInstance();

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id.details_fragment_container, fragment)
                    .commit();

            //fragment.setList(cities);
        }
    }
}
