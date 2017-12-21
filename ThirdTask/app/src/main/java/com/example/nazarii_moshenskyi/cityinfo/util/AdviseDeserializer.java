package com.example.nazarii_moshenskyi.cityinfo.util;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class AdviseDeserializer implements JsonDeserializer<Advise> {

    @Override
    public Advise deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Advise advise = new Advise();
        JsonObject adviseObject = json.getAsJsonObject();
        JsonObject innerObject = adviseObject.get("UA").getAsJsonObject();
        advise.setAdvise(innerObject.get("advise").getAsString());

        return advise;
    }
}
