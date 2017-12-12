package com.example.nazarii_moshenskyi.cityinfo.utils;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;
import com.example.nazarii_moshenskyi.cityinfo.data.model.CountryList;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Map;

public class CountryListDeserializer implements JsonDeserializer<CountryList> {
    @Override
    public CountryList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CountryList result = new CountryList();
        JsonObject jsonObject = json.getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            Country country = context.deserialize(entry.getValue(), Country.class);
            country.setName(entry.getKey());
            result.add(country);
        }

        return result;
    }
}
