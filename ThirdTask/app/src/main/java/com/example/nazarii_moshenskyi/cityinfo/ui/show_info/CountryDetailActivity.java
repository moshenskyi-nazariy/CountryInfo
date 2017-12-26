package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.nazarii_moshenskyi.cityinfo.R;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class CountryDetailActivity extends AppCompatActivity {
    private String coutryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            coutryName = intent.getStringExtra(COUNTRY_EXTRA);

            CountryDetailFragment fragment = CountryDetailFragment.newInstance(coutryName);

            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction()
                    .add(R.id.details_fragment_container, fragment)
                    .commit();

        }
    }
}
