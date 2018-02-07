package com.nazarii_moshenskyi.countryinfo.ui.show_info.model.mapper;

import com.nazarii_moshenskyi.countryinfo.data.model.Advise;
import com.nazarii_moshenskyi.countryinfo.data.model.Currency;
import com.nazarii_moshenskyi.countryinfo.data.model.Electricity;
import com.nazarii_moshenskyi.countryinfo.data.model.Names;
import com.nazarii_moshenskyi.countryinfo.data.model.Timezone;
import com.nazarii_moshenskyi.countryinfo.data.model.Water;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.CurrencyInfo;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.DangerInfo;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.ElectricityInfo;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.TimezoneInfo;
import com.nazarii_moshenskyi.countryinfo.ui.show_info.model.WaterInfo;

public class CountryInfoMapper {
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
        if (names != null && names.getContinent() != null) {
            return names.getContinent();
        } else {
            return "-";
        }
    }
}
