package com.nazarii_moshenskyi.countryinfo.data.model;

import java.util.List;

public class Currency {
    private String name;
    private String code;
    private String symbol;
    private String rate;
    private List<Compare> compare = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public List<Compare> getCompare() {
        return compare;
    }

    public void setCompare(List<Compare> compare) {
        this.compare = compare;
    }

}
