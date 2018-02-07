package com.nazarii_moshenskyi.countryinfo.ui.show_info.model;

import com.nazarii_moshenskyi.countryinfo.data.model.Month;
import com.nazarii_moshenskyi.countryinfo.data.model.Weather;

import java.util.List;

public class WeatherInfo implements RowType {
    private List<Month> weather;

    public WeatherInfo(Weather weather) {
        this.weather = weather.getMonths();
    }

    public List<Month> getWeather() {
        return weather;
    }
}
