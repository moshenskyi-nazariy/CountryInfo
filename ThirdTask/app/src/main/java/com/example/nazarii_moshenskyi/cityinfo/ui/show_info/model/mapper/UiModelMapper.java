package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Currency;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Electricity;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Timezone;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Water;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.CurrencyInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.DangerInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.ElectricityInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.TimezoneInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.WaterInfo;
import com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model.mapper.DangerLevelMapper;

public class UiModelMapper {
    public static CurrencyInfo convertCurrency(Currency currency) {
        CurrencyInfo currencyInfo = new CurrencyInfo();
        currencyInfo.setName(currency.getName());
        currencyInfo.setRate(currency.getRate());

        return currencyInfo;
    }

    public static ElectricityInfo convertElectricity(Electricity electricity) {
        ElectricityInfo electricityInfo = new ElectricityInfo();
        electricityInfo.setVoltage(electricity.getVoltage());
        electricityInfo.setFrequency(electricity.getFrequency());
        electricityInfo.setPlugs(electricity.getPlugs());

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
        dangerInfo.setLevel(DangerLevelMapper.convertLevel(advise.getAdvise()));
        return dangerInfo;
    }
}
