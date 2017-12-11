package com.example.nazarii_moshenskyi.cityinfo.show_cities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nazarii_moshenskyi.cityinfo.R;

public class MainActivity extends AppCompatActivity implements CityFragment.OnFragmentInteractionListener {
    private ICityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CityPresenter(getApplicationContext());

        CityFragment cityFragment = CityFragment.newInstance(presenter);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.city_name_container, cityFragment)
                .commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
