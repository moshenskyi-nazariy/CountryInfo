package com.example.nazarii_moshenskyi.cityinfo.util;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Vaccine;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class VaccineDeserializer implements JsonDeserializer<Vaccine> {
    @Override
    public Vaccine deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Vaccine vaccine = new Vaccine();
        JsonObject vaccineObject = json.getAsJsonObject();

        vaccine.setName(vaccineObject.get("name").getAsString());
        vaccine.setMessage(vaccineObject.get("message").getAsString());
        return vaccine;
    }
}
