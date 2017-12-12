package com.example.nazarii_moshenskyi.cityinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.cityinfo.data.LocalGsonRepository;
import com.example.nazarii_moshenskyi.cityinfo.show_cities.CityPresenter;
import com.example.nazarii_moshenskyi.cityinfo.show_cities.ICityPresenter;

public class MainActivity extends AppCompatActivity {
    private ICityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        presenter = new CityPresenter(getApplicationContext());
        presenter.setList(recyclerView);

        presenter.setRepository(new LocalGsonRepository(getApplicationContext()));
        presenter.start();
    }

}
