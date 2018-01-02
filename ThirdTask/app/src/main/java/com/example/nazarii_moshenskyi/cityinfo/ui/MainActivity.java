package com.example.nazarii_moshenskyi.cityinfo.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nazarii_moshenskyi.cityinfo.CountryInfoApplication;
import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryDetailActivity;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryDetailFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.StubFragment;

import javax.inject.Inject;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class MainActivity extends AppCompatActivity implements MainView, CountryFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    private static final String MASTER_TAG = "master";
    private static final String DETAIL_TAG = "detail";
    private static final String STUB_TAG = "stub";
    @Inject
    MainPresenter presenter;
    private CountryDetailFragment detailFragment;
    private StubFragment stubFragment;
    private CountryFragment masterFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CountryInfoApplication) getApplication()).getCountryComponent().inject(this);

        presenter.attachView(this);
        presenter.start();

        showCountries();
    }

    private void showCountries() {
        if ((masterFragment = (CountryFragment) getSupportFragmentManager()
                .findFragmentByTag(MASTER_TAG)) == null) {
            masterFragment = CountryFragment.newInstance();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.country_name_container, masterFragment, MASTER_TAG)
                .commit();
    }

    public void setDetailFragment() {
        Log.d(TAG, "setDetailFragment: Mode = tablet");
        if ((stubFragment = (StubFragment) getSupportFragmentManager()
                .findFragmentByTag(STUB_TAG)) == null) {
            stubFragment = StubFragment.newInstance();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.city_name_container, stubFragment, STUB_TAG)
                .commit();
    }

    public int getSize() {
        Configuration configuration = getResources().getConfiguration();
        return configuration.screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
    }

    public void replaceDetailFragment(Country country) {
        Log.d(TAG, "onClick: name=" + country.getName() + "sending to DetailFragment");

        detailFragment = CountryDetailFragment.newInstance(country.getName());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.city_name_container, detailFragment, DETAIL_TAG)
                .commit();
    }

    public void startDetailActivity(Country country) {
        Log.d(TAG, "onClick: name=" + country.getName() + "sending to DetailActivity");
        Intent intent = new Intent(getApplicationContext(), CountryDetailActivity.class);
        intent.putExtra(COUNTRY_EXTRA, country.getName());
        startActivity(intent);
    }

    @Override
    public void onCountryClicked(Country country) {
        presenter.onItemClicked(country);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
