package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.nazarii_moshenskyi.cityinfo.R;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryInfo;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Language;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Vaccine;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.ApiFactory;
import com.example.nazarii_moshenskyi.cityinfo.interactor.api.CountryService;
import com.example.nazarii_moshenskyi.cityinfo.interactor.repository.CountryInfoRepository;
import com.example.nazarii_moshenskyi.cityinfo.ui.BaseView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import static com.example.nazarii_moshenskyi.cityinfo.ui.Contract.COUNTRY_EXTRA;

public class CountryInfoActivity extends AppCompatActivity implements BaseView<CountryInfo> {

    private TextView electricityTextView;
    private TextView itemName;
    private TextView languages;
    private TextView vaccinations;
    private TextView advises;

    private String countryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);
        initViews();

        Intent intent = getIntent();
        countryName = intent.getStringExtra(COUNTRY_EXTRA);

        CountryService infoService = ApiFactory.getCountryInfoService();
        CountryInfoRepository repository = new CountryInfoRepository(infoService, countryName);
        CountryInfoPresenter presenter = new CountryInfoPresenter(this, repository);
        presenter.getInfo();

    }

    private void initViews() {
        electricityTextView = findViewById(R.id.sockets_and_plugs);
        itemName = findViewById(R.id.item_name);
        languages = findViewById(R.id.languages);
        vaccinations = findViewById(R.id.vaccinations);
        advises = findViewById(R.id.advises);
    }

    @Override
    public void onLoad(Observable<CountryInfo> infoItems) {
        infoItems.subscribe(new Consumer<CountryInfo>() {
            @Override
            public void accept(CountryInfo countryInfo) throws Exception {
                display(countryInfo);
            }
        });
    }

    private void display(CountryInfo countryInfo) {
        itemName.setText(countryName);

        Electricity electricity = countryInfo.getElectricity();
        List<String> plugs = electricity.getPlugs();
        electricityTextView.setText(getResources().getString(R.string.sockets_placeholder, countryName,
                Integer.parseInt(electricity.getVoltage()),
                Integer.parseInt(electricity.getFrequency()), plugs.get(0), plugs.get(1)));

        StringBuilder builder = getLanguages(countryInfo);
        languages.setText(builder);

        getVaccinations(countryInfo, builder);
        vaccinations.setText(builder);

        getAdvises(countryInfo, builder);
        advises.setText(builder);
    }

    private void getAdvises(CountryInfo countryInfo, StringBuilder builder) {
        builder.setLength(0);
        Advise adviseList = countryInfo.getAdvise();
        builder.append("*UA: \n\t").append(adviseList.getUA().getUrl()).append(" \n\t")
                .append(adviseList.getUA().getAdvise()).append("\n")
                .append("*CA: \n\t").append(adviseList.getCA().getUrl()).append(" \n\t")
                .append(adviseList.getCA().getAdvise()).append("\n");
    }

    private void getVaccinations(CountryInfo countryInfo, StringBuilder builder) {
        builder.setLength(0);
        List<Vaccine> vaccineList = countryInfo.getVaccinations();
        for (Vaccine item : vaccineList) {
            builder.append("*").append(item.getName()).append(": \n").append(item.getMessage())
                    .append("\n");
        }
    }

    @NonNull
    private StringBuilder getLanguages(CountryInfo countryInfo) {
        List<Language> languageList = countryInfo.getLanguage();
        StringBuilder builder = new StringBuilder();
        for (Language item : languageList) {
            builder.append(item.getLanguage()).append("(Official: ").append(item.getOfficial())
                    .append(");").append("\n");
        }
        return builder;
    }
}
