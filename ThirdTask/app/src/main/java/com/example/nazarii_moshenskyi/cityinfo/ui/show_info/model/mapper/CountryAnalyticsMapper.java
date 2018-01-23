package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper;

import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.AnalyticsInfo;

import java.util.List;

public class CountryAnalyticsMapper {

    public static AnalyticsInfo convertCountryAnalytics(List<CountryAnalytics> analytics) {
        if (!analytics.isEmpty()) {
            CountryAnalytics countryAnalytics = analytics.get(0);

            AnalyticsInfo info = new AnalyticsInfo();
            info.setArea(convertAnalyticsItem(countryAnalytics.getArea()));
            info.setPopulation(convertAnalyticsItem(countryAnalytics.getPopulation()));
            info.setFlag(countryAnalytics.getFlag());
            return info;
        }

        AnalyticsInfo info = new AnalyticsInfo();
        info.setArea("-");
        info.setPopulation("-");
        return info;
    }

    private static String convertAnalyticsItem(Integer item) {
        if (item != null) {
            return String.valueOf(item);
        }
        return "-";
    }

}
