package com.example.nazarii_moshenskyi.cityinfo.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country implements Parcelable {

    @SerializedName("alpha2Code")
    @Expose
    private String alpha2Code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameSanitized")
    @Expose
    private String nameSanitized;

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSanitized() {
        return nameSanitized;
    }

    public void setNameSanitized(String nameSanitized) {
        this.nameSanitized = nameSanitized;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public Country() {
    }

    protected Country(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}