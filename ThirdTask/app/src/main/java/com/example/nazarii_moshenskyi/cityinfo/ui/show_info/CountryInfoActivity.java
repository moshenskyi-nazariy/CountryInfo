package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.ApiFactory;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.BaseView;

import io.reactivex.Observable;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class CountryInfoActivity extends AppCompatActivity implements BaseView<CountryInfo> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);

        Intent intent = getIntent();
        String countryName = intent.getStringExtra(COUNTRY_EXTRA);

        CountryService infoService = ApiFactory.getCountryInfoService();
        CountryInfoRepository repository = new CountryInfoRepository(infoService, countryName);
        CountryInfoPresenter presenter = new CountryInfoPresenter(this, repository);
        presenter.getInfo();

    }

    @Override
    public void onLoad(Observable<CountryInfo> infoItems) {
    }
}
