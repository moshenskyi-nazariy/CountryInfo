package com.example.nazarii_moshenskyi.thirdtask.show_cities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.nazarii_moshenskyi.thirdtask.BasePresenter;
import com.example.nazarii_moshenskyi.thirdtask.R;

public class MainActivity extends AppCompatActivity {
    private BasePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.recycler_view);

        presenter = new CityPresenter(getApplicationContext(), list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.start();
    }



}
