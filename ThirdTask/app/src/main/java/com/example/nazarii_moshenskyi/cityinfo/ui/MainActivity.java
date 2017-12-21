package com.example.nazarii_moshenskyi.cityinfo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.ApiFactory;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryAdapter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryItemDecorator;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryPresenter;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryDetailActivity;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryDetailFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.StubFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseView<List<Country>>,
        CountryFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    private CountryPresenter presenter;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CountryAdapter adapter;
    private FragmentManager fragmentManager;
    //private CountryDetailFragment detailFragment;
    private FrameLayout detailFrame;
    private CountryFragment masterFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        checkLayout();

        initList();

        CountryService service = ApiFactory.getCountryService();
        CountryRepository repository = new CountryRepository(service);
        presenter = new CountryPresenter(this, repository);
        presenter.getCountries();
    }

    private void checkLayout() {
        detailFrame = findViewById(R.id.city_name_container);
        if (detailFrame != null) {
            Log.d(TAG, "checkLayout: Mode = tablet");
            StubFragment fragment = StubFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.city_name_container, fragment)
                    .commit();
        }
    }

    private void initList() {
        recyclerView = findViewById(R.id.country_list);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CountryItemDecorator((int) getResources().
                getDimension(R.dimen.margins)));
    }

    @Override
    public void onLoad(List<Country> countries) {
        /*adapter = new CountryAdapter(countries, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);*/

        Log.d(TAG, "onLoad: " + countries.size());

        masterFragment = CountryFragment.newInstance(countries);
        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.country_name_container, masterFragment)
                .commit();
    }


    @Override
    public void onCountryClicked(int position) {
        /*Intent intent = new Intent(getApplicationContext(), CountryInfoActivity.class);
        intent.putExtra(COUNTRY_EXTRA, country.getName());
        startActivity(intent);*/

        if (detailFrame != null) {
            Log.d(TAG, "onCountryClicked: position=" + position + "sending to DetailFragment" );
            CountryDetailFragment detailFragment = CountryDetailFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.city_name_container, detailFragment)
                    .commit();
        } else {
            Log.d(TAG, "onCountryClicked: position=" + position + "sending to DetailActivity" );
            Intent intent = new Intent(getApplicationContext(), CountryDetailActivity.class);
            //intent.putExtra(EXTRA_CITIES, (Parcelable) cityList);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (masterFragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .remove(masterFragment)
                    .commit();
        }    }
}
