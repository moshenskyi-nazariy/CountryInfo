package com.example.nazarii_moshenskyi.cityinfo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_country.CountryFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryDetailActivity;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.CountryDetailFragment;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.StubFragment;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class MainActivity extends AppCompatActivity implements CountryFragment.OnFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    private FrameLayout detailFrame;
    private CountryFragment masterFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkLayout();

        showCountries();

    }

    private void showCountries() {
        masterFragment = CountryFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.country_name_container, masterFragment)
                .commit();
    }

    private void checkLayout() {
        detailFrame = findViewById(R.id.city_name_container);
        if (detailFrame != null) {
            Log.d(TAG, "checkLayout: Mode = tablet");
            StubFragment fragment = StubFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.city_name_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onCountryClicked(Country country) {
        if (detailFrame != null) {
            Log.d(TAG, "onClick: name=" + country.getName() + "sending to DetailFragment" );
            CountryDetailFragment detailFragment = CountryDetailFragment.newInstance(country.getName());
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.city_name_container, detailFragment)
                    .commit();
        } else {
            Log.d(TAG, "onClick: name=" + country.getName() + "sending to DetailActivity" );
            Intent intent = new Intent(getApplicationContext(), CountryDetailActivity.class);
            intent.putExtra(COUNTRY_EXTRA, country.getName());
            startActivity(intent);
        }
    }
}
