package com.nazarii_moshenskyi.countryinfo.dependecies;

import com.nazarii_moshenskyi.countryinfo.ui.main.view.MainActivity;
import com.nazarii_moshenskyi.countryinfo.ui.show_country.view.CountryFragment;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.view.CountryDetailFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresentersModule.class, NetModule.class, ApiModule.class, RxModule.class, UtilsModule.class})
public interface CountryComponent {

    void inject(CountryFragment countryFragment);

    void inject(CountryDetailFragment countryDetailFragment);

    void inject(MainActivity activity);
}
