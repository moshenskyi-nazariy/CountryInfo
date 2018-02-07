package com.nazarii_moshenskyi.countryinfo.ui.show_info.view;

import com.nazarii_moshenskyi.countryinfo.ui.base.BaseRxMvpView;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.AnalyticsInfo;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.RowType;

import java.util.List;

public interface CountryInfoMvpView extends BaseRxMvpView {

    void onLoad(List<RowType> infoModel);

    void setBackground(String flagUrl);

    void setTitleInfo(AnalyticsInfo analytics, String continent);

}
