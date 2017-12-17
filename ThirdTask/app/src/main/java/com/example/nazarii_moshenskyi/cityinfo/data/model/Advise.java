
package com.example.nazarii_moshenskyi.cityinfo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Advise {

    @SerializedName("UA")
    @Expose
    private UA uA;
    @SerializedName("CA")
    @Expose
    private CA cA;

    public UA getUA() {
        return uA;
    }

    public void setUA(UA uA) {
        this.uA = uA;
    }

    public CA getCA() {
        return cA;
    }

    public void setCA(CA cA) {
        this.cA = cA;
    }

}
