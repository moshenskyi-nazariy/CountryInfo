package com.example.nazarii_moshenskyi.cityinfo.ui.main.view;

import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.CountryInfoApplication;
import com.example.nazarii_moshenskyi.cityinfo.ui.main.presenter.MainMvpPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.main.presenter.MainPresenterImpl;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.view.CountryFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view.CountryDetailActivity;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view.CountryDetailFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view.StubFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;
import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_LIST;

public class MainActivity extends AppCompatActivity implements MainMvpView, CountryFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    private CountryFragment masterFragment;
    private ConstraintLayout layout;

    @Inject
    MainMvpPresenter presenter;

    private List<String> list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main_layout);
        list = new ArrayList<>(0);

        Application application = getApplication();
        if (application == null) {
            return;
        }
        ((CountryInfoApplication) application).getCountryComponent().inject(this);

        Toolbar toolbar = findViewById(R.id.include);
        setSupportActionBar(toolbar);

        presenter = new MainPresenterImpl();

        presenter.attachView(this);
        presenter.defineLayout();

        showCountries();
    }

    private void showCountries() {
        masterFragment = CountryFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.country_name_container, masterFragment)
                .commit();
    }

    public void setDetailFragment() {
        Log.d(TAG, "setDetailFragment: Mode = tablet");
        View view = findViewById(R.id.city_name_container);
        ConstraintSet set = new ConstraintSet();
        set.clone(layout);
        set.setGuidelinePercent(R.id.guideline, 0.4F);
        set.applyTo(layout);
        view.setVisibility(View.VISIBLE);

        StubFragment fragment = StubFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.city_name_container, fragment)
                .commit();
    }

    public boolean isTablet() {
        return (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public void replaceDetailFragment(Country country) {
        Log.d(TAG, "onClick: name=" + country.getName() + "sending to DetailFragment");
        CountryDetailFragment detailFragment = CountryDetailFragment.newInstance(country.getName());
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.city_name_container, detailFragment)
                .commit();
    }

    public void startDetailActivity(Country country) {
        Log.d(TAG, "onClick: name=" + country.getName() + " sending to DetailActivity");
        Intent intent = new Intent(getApplicationContext(), CountryDetailActivity.class);
        intent.putExtra(COUNTRY_EXTRA, list.indexOf(country.getName()));
        intent.putStringArrayListExtra(COUNTRY_LIST, (ArrayList<String>) list);
        startActivity(intent);
    }

    @Override
    public boolean isLandscape() {
        return getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public void onCountryClicked(Country country) {
        presenter.onItemClicked(country);
    }

    @Override
    public void onCountriesLoaded(List<Country> list) {
        for (Country country : list) {
            this.list.add(country.getName());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                masterFragment.onTextChanged(newText);
                return true;
            }
        });

        return true;
    }

}
