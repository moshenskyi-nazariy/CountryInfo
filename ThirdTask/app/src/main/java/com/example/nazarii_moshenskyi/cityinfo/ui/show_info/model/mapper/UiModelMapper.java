package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Currency;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Names;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Timezone;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Water;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.AnalyticsInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.CurrencyInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.DangerInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ElectricityInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.TimezoneInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.WaterInfo;

import java.util.List;

//TODO: Divide into different classes mapping its own type
public class UiModelMapper {
    public static CurrencyInfo convertCurrency(Currency currency) {
        CurrencyInfo currencyInfo = new CurrencyInfo();

        if (currency.getName() != null && currency.getRate() != null) {
            currencyInfo.setName(currency.getName());
            String rate = currency.getRate();

            double rateNumber = Double.valueOf(rate) * 100;
            rateNumber = Math.round(rateNumber);
            rateNumber = rateNumber / 100;

            rate = String.valueOf(rateNumber);
            currencyInfo.setRate(rate);
        }

        return currencyInfo;
    }

    public static ElectricityInfo convertElectricity(Electricity electricity) {
        ElectricityInfo electricityInfo = new ElectricityInfo();
        if (electricity.getVoltage() != null) {
            electricityInfo.setVoltage(electricity.getVoltage());
        }

        if (electricity.getFrequency() != null) {
            electricityInfo.setFrequency(electricity.getFrequency());
        }

        if (electricity.getPlugs() != null) {
            electricityInfo.setPlugs(electricity.getPlugs());
        }
        return electricityInfo;
    }

    public static WaterInfo convertWater(Water water) {
        WaterInfo waterInfo = new WaterInfo();

        if (water != null) {
            waterInfo.setShortInfo(water.getShort());
        }
        return waterInfo;
    }

    public static TimezoneInfo convertTimezone(Timezone timezone) {
        TimezoneInfo timezoneInfo = new TimezoneInfo();

        if (timezone != null) {
            timezoneInfo.setName(timezone.getName());
        }
        return timezoneInfo;
    }

    public static DangerInfo convertAdvise(Advise advise) {
        DangerInfo dangerInfo = new DangerInfo();
        if (advise != null) {
            dangerInfo.setLevel(DangerLevelMapper.convertLevel(advise.getAdvise()));
        }
        return dangerInfo;
    }

    public static String convertContinent(Names names) {
        if(names != null && names.getContinent() != null) {
            return names.getContinent();
        } else {
            return "-";
        }
    }

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
