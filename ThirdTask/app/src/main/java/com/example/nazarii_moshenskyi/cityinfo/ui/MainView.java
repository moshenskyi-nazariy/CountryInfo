package com.example.nazarii_moshenskyi.cityinfo.ui;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

public interface MainView {

    int getSize();

    void setDetailFragment();

    void replaceDetailFragment(Country country);

    void startDetailActivity(Country country);
}
