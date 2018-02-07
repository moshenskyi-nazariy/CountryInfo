package com.nazarii_moshenskyi.countryinfo.data.model;

import com.google.gson.annotations.SerializedName;

public class Maps {

    private String lat;
    @SerializedName("long")
    private String _long;
    private String zoom;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLong() {
        return _long;
    }

    public void setLong(String _long) {
        this._long = _long;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }

}
