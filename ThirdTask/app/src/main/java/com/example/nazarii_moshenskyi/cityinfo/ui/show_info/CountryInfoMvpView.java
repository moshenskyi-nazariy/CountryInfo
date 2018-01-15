package com.example.nazarii_moshenskyi.cityinfo.ui.show_info;

import com.example.nazarii_moshenskyi.cityinfo.ui.BaseMvpView;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.DangerInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.RowType;

import java.util.List;

public interface CountryInfoMvpView extends BaseMvpView {

    void onLoad(List<RowType> infoModel, DangerInfo rating);

    void setBackground(String flagUrl);

}
