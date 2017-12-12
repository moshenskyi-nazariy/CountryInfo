package com.example.nazarii_moshenskyi.cityinfo.utils;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class CountryDeserializer implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Country country = new Country();
        JsonArray cities = json.getAsJsonArray();

        for (JsonElement city : cities) {
            country.addCity(city.getAsString());
        }

        return country;
    }
}
