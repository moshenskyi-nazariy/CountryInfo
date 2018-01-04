package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.nazarii_moshenskyi.cityinfo.R;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class CountryDetailActivity extends AppCompatActivity {
    private String countryName;
    private ViewPager itemsPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        itemsPager = findViewById(R.id.items_pager);
        itemsPager.setAdapter(new ItemsPagerAdapter(getSupportFragmentManager()));

        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);

        /*if (savedInstanceState == null) {
            Intent intent = getIntent();
            countryName = intent.getStringExtra(COUNTRY_EXTRA);

            CountryDetailFragment fragment = CountryDetailFragment.newInstance(countryName);

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id., fragment)
                    .commit();

        }*/

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(countryName);
        }
    }
}
