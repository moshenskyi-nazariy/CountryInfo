package com.nazarii_moshenskyi.countryinfo.util.deserializer;

import com.nazarii_moshenskyi.countryinfo.data.model.Month;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import static com.nazarii_moshenskyi.countryinfo.data.model.Month.MonthContract.PAVG;
import static com.nazarii_moshenskyi.countryinfo.data.model.Month.MonthContract.PMAX;
import static com.nazarii_moshenskyi.countryinfo.data.model.Month.MonthContract.PMIN;
import static com.nazarii_moshenskyi.countryinfo.data.model.Month.MonthContract.TAVG;
import static com.nazarii_moshenskyi.countryinfo.data.model.Month.MonthContract.TMAX;
import static com.nazarii_moshenskyi.countryinfo.data.model.Month.MonthContract.TMIN;

public class MonthDeserializer implements JsonDeserializer<Month> {
    @Override
    public Month deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Month month = new Month();
        JsonObject monthObject = json.getAsJsonObject();

        month.settMin(monthObject.get(TMIN).getAsString());
        month.settMax(monthObject.get(TMAX).getAsString());
        month.settAvg(monthObject.get(TAVG).getAsString());
        month.setpMin(monthObject.get(PMIN).getAsString());
        month.setpMax(monthObject.get(PMAX).getAsString());
        month.setpAvg(monthObject.get(PAVG).getAsString());

        return month;
    }
}
