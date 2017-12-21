package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.ui.model.InfoModel;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class CountryInfoActivity extends AppCompatActivity implements CountryInfoView, View.OnClickListener {

    private boolean isOld = false;
    private SparseArray<Object> associatedMap;
    private String countryName;

    private TextView nameItem;
    private TextView adviseItem;
    private RecyclerView vaccinationItem;
    private RecyclerView languagesItem;
    private TextView currencyItem;
    private TextView socketsItem;

    private LinearLayoutManager layoutManagerLanguages;
    private LinearLayoutManager layoutManagerVaccines;
    private LanguageAdapter languageAdapter;
    private VaccineAdapter vaccineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);
        layoutManagerLanguages = new LinearLayoutManager(getApplicationContext());
        layoutManagerVaccines = new LinearLayoutManager(getApplicationContext());

        Intent intent = getIntent();
        countryName = intent.getStringExtra(COUNTRY_EXTRA);
        nameItem = findViewById(R.id.name_item);
        nameItem.setText(countryName);

        initImages();
        initDataRepresentation();
        associateIds();

        CountryInfoPresenter presenter = new CountryInfoPresenter(this, countryName);
        presenter.getInfo();

    }

    private void initDataRepresentation() {
        adviseItem = findViewById(R.id.advises_item);
        socketsItem = findViewById(R.id.sockets_item);
        currencyItem = findViewById(R.id.currency_item);
        vaccinationItem = findViewById(R.id.list_vaccinations);
        languagesItem = findViewById(R.id.list_languages);

        languageAdapter = new LanguageAdapter();
        languagesItem.setAdapter(languageAdapter);
        languagesItem.setLayoutManager(layoutManagerLanguages);

        vaccineAdapter = new VaccineAdapter();
        vaccinationItem.setAdapter(vaccineAdapter);
        vaccinationItem.setLayoutManager(layoutManagerVaccines);
    }

    private void associateIds() {
        associatedMap = new SparseArray<>();
        associatedMap.put(R.id.advise_arrow_down, R.id.advises_item);
        associatedMap.put(R.id.vaccinations_arrow_down, R.id.list_vaccinations);
        associatedMap.put(R.id.languages_arrow_down, R.id.list_languages);
        associatedMap.put(R.id.currency_arrow_down, R.id.currency_item);
        associatedMap.put(R.id.sockets_arrow_down, R.id.sockets_item);
    }

    private void initImages() {
        ImageView adviseView = findViewById(R.id.advise_arrow_down);
        ImageView vaccinationView = findViewById(R.id.vaccinations_arrow_down);
        ImageView languagesView = findViewById(R.id.languages_arrow_down);
        ImageView socketView = findViewById(R.id.sockets_arrow_down);
        ImageView currencyView = findViewById(R.id.currency_arrow_down);

        adviseView.setOnClickListener(this);
        vaccinationView.setOnClickListener(this);
        languagesView.setOnClickListener(this);
        socketView.setOnClickListener(this);
        currencyView.setOnClickListener(this);
    }

    @Override
    public void onLoad(InfoModel infoModel) {
        adviseItem.setText(infoModel.getAdvise());
        currencyItem.setText(infoModel.getCurrency());
        socketsItem.setText(infoModel.getSockets());

        languageAdapter.update(infoModel.getLanguages());
        vaccineAdapter.update(infoModel.getVaccinations());
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        View visibleView = findViewById((int) associatedMap.get(id));
        if (isOld) {
            visibleView.setVisibility(View.GONE);
        } else {
            visibleView.setVisibility(View.VISIBLE);
        }
        isOld = !isOld;
    }

}