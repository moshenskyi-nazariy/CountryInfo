package com.example.nazarii_moshenskyi.cityinfo.data;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class GsonService {
    private Context context;

    public GsonService(Context context) {
        this.context = context;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("countriesToCities.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        context = null;
        return json;
    }
}
