package com.example.nazarii_moshenskyi.cityinfo.ui.model;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Language;
import com.example.nazarii_moshenskyi.cityinfo.data.model.UA;
import com.example.nazarii_moshenskyi.cityinfo.data.model.Vaccine;

import java.util.List;

public class InfoModel {
    private String currency;
    private List<Vaccine> vaccinations;
    private List<Language> languages;
    private UA advise;
    private String sockets;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Vaccine> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccine> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public UA getAdvise() {
        return advise;
    }

    public void setAdvise(UA advise) {
        this.advise = advise;
    }

    public String getSockets() {
        return sockets;
    }

    public void setSockets(String sockets) {
        this.sockets = sockets;
    }
}
