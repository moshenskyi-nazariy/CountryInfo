package com.example.nazarii_moshenskyi.cityinfo.util.deserializer;

import android.util.Log;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Advise;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class AdviseDeserializer implements JsonDeserializer<Advise> {
    private static final String TAG = "AdviseDeserializer";

    @Override
    public Advise deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            JsonObject adviseObject = json.getAsJsonObject();
            if (adviseObject != null) {
                JsonElement ua = adviseObject.get("UA");
                if (ua != null) {
                    JsonObject innerObject = ua.getAsJsonObject();
                    Advise advise = new Advise();
                    advise.setAdvise(innerObject.get("advise").getAsString());
                    return advise;
                }
            }
        } catch (IllegalStateException ex) {
            Log.d(TAG, "deserialize: there is no items");
        }
        return null;
    }
}
