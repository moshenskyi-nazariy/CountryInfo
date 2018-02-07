package com.example.nazarii_moshenskyi.cityinfo.data.model;

import java.util.List;

public class CountryInfo {
    private Names names;
    private Maps maps;
    private Timezone timezone;
    private List<Language> language = null;
    private Electricity electricity;
    private Telephone telephone;
    private Water water;
    private List<Vaccine> vaccinations = null;
    private Currency currency;
    private Weather weather;
    private Advise advise;
    private List<Neighbor> neighbors;

    public Names getNames() {
        return names;
    }

    public void setNames(Names names) {
        this.names = names;
    }

    public Maps getMaps() {
        return maps;
    }

    public void setMaps(Maps maps) {
        this.maps = maps;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    public Electricity getElectricity() {
        return electricity;
    }

    public void setElectricity(Electricity electricity) {
        this.electricity = electricity;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public Water getWater() {
        return water;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public List<Vaccine> getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List<Vaccine> vaccinations) {
        this.vaccinations = vaccinations;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Advise getAdvise() {
        return advise;
    }

    public void setAdvise(Advise advise) {
        this.advise = advise;
    }

    public List<Neighbor> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Neighbor> neighbors) {
        this.neighbors = neighbors;
    }
}
