package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.view;

import com.example.nazarii_moshenskyi.cityinfo.ui.base.BaseMvpView;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.AnalyticsInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;

import java.util.List;

public interface CountryInfoMvpView extends BaseMvpView {

    void onLoad(List<RowType> infoModel);

    void setBackground(String flagUrl);

    void setTitleInfo(AnalyticsInfo analytics, String continent);

    void showLoadingDialog();

    void hideLoadingDialog();

}
