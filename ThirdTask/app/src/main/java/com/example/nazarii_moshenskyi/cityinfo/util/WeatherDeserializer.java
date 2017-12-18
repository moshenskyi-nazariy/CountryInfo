package com.example.nazarii_moshenskyi.cityinfo.util;


import com.example.nazarii_moshenskyi.cityinfo.data.model.Month;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Weather;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Map;

public class WeatherDeserializer implements JsonDeserializer<Weather> {
    @Override
    public Weather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Weather weather = new Weather();
        JsonObject weatherObject = json.getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : weatherObject.entrySet()) {
            Month month = context.deserialize(entry.getValue(), Month.class);
            month.setName(entry.getKey());
            weather.addMonth(month);
        }

        return weather;
    }
}
