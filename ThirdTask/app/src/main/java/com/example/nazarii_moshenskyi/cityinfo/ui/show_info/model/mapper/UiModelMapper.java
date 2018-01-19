package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryAnalytics;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Currency;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Names;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Timezone;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Water;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.CurrencyInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.DangerInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ElectricityInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.TimezoneInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.WaterInfo;

import java.util.List;

//TODO: Null-Object Pattern
public class UiModelMapper {
    public static CurrencyInfo convertCurrency(Currency currency) {
        CurrencyInfo currencyInfo = new CurrencyInfo();

        if (currency.getName() != null) {
            currencyInfo.setName(currency.getName());
        }
        if (currency.getRate() != null) {
            currencyInfo.setRate(currency.getRate());
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
        waterInfo.setShortInfo(water.getShort());

        return waterInfo;
    }

    public static TimezoneInfo convertTimezone(Timezone timezone) {
        TimezoneInfo timezoneInfo = new TimezoneInfo();
        timezoneInfo.setName(timezone.getName());

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
        return names.getContinent();
    }

    public static CountryAnalytics convertCountryAnalytics(List<CountryAnalytics> analytics) {
        if (!analytics.isEmpty()) {
            return analytics.get(0);
        }

        return null;
    }
}
