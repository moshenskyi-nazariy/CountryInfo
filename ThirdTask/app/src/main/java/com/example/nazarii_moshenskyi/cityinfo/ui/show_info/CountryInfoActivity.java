package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.ApiFactory;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.BaseView;

import io.reactivex.Observable;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class CountryInfoActivity extends AppCompatActivity implements BaseView<CountryInfo>, View.OnClickListener {

    private boolean isOld = false;

    private SparseArray<Object> associatedMap;

    private String countryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);

        initViews();
        associateIds();

        Intent intent = getIntent();
        countryName = intent.getStringExtra(COUNTRY_EXTRA);

        CountryService infoService = ApiFactory.getCountryInfoService();
        CountryInfoRepository repository = new CountryInfoRepository(infoService, countryName);
        CountryInfoPresenter presenter = new CountryInfoPresenter(this, repository);
        presenter.getInfo();

    }

    private void associateIds() {
        associatedMap = new SparseArray<>();
        associatedMap.put(R.id.advise_arrow_down, R.id.advises_item);
        associatedMap.put(R.id.vaccinations_arrow_down, R.id.list_vaccinations);
        associatedMap.put(R.id.languages_arrow_down, R.id.list_languages);
        associatedMap.put(R.id.currency_arrow_down, R.id.currancy_item);
        associatedMap.put(R.id.sockets_arrow_down, R.id.sockets_item);

    }

    private void initViews() {
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

    //TODO:make parametr CountryInfo
    @Override
    public void onLoad(Observable<CountryInfo> infoItems) {
        /*infoItems.subscribe(new Consumer<CountryInfo>() {
            @Override
            public void accept(CountryInfo countryInfo) throws Exception {
                display(countryInfo);
            }
        });*/
    }

    private void display(CountryInfo countryInfo) {

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
