package com.example.nazarii_moshenskyi.cityinfo.ui.show_info.model;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Month;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Weather;

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
