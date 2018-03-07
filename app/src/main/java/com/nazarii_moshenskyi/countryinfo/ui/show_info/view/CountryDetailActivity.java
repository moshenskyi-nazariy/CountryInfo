package com.nazarii_moshenskyi.countryinfo.ui.show_info.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

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

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Intent intent = getIntent();
        countryPosition = intent.getIntExtra(COUNTRY_EXTRA, 0);
        countries = intent.getStringArrayListExtra(COUNTRY_LIST);

        setToolbar();

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(countries.get(countryPosition));
            supportActionBar.setDisplayHomeAsUpEnabled(true);
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
