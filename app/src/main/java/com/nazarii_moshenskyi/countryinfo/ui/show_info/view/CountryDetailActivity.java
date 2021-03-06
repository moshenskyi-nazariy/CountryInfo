package com.nazarii_moshenskyi.countryinfo.ui.show_info.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nazarii_moshenskyi.countryinfo.R;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.view.view_pager.ItemsPagerAdapter;

import java.util.List;

import static com.nazarii_moshenskyi.countryinfo.ui.Contract.COUNTRY_EXTRA;
import static com.nazarii_moshenskyi.countryinfo.ui.Contract.COUNTRY_LIST;

public class CountryDetailActivity extends AppCompatActivity {
    private int countryPosition;
    private List<String> countries;

    private ViewPager itemsPager;
    private ItemsPagerAdapter itemsPagerAdapter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Intent intent = getIntent();
        countryPosition = intent.getIntExtra(COUNTRY_EXTRA, 0);
        countries = intent.getStringArrayListExtra(COUNTRY_LIST);

        setToolbar();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(countries.get(countryPosition));
        }
        setPager();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
    }

    private void setPager() {
        itemsPager = findViewById(R.id.items_pager);
        itemsPagerAdapter = new ItemsPagerAdapter(getSupportFragmentManager(), countries);
        itemsPager.setAdapter(itemsPagerAdapter);

        itemsPager.setCurrentItem(countryPosition);

        itemsPager.addOnPageChangeListener(new SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (getSupportActionBar() != null) {
                    toolbar.setTitle(countries.get(position));
                }
            }
        });
    }
}
