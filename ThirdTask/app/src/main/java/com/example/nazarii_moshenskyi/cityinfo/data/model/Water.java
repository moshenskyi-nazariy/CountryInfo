
package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Water {

    @SerializedName("short")
    @Expose
    private String _short;
    @SerializedName("full")
    @Expose
    private String full;

    public String getShort() {
        return _short;
    }

    public void setShort(String _short) {
        this._short = _short;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

}
