package com.nazarii_moshenskyi.countryinfo.data.model;

public class Month {

    private String name;

    private String tMin;

    private String tMax;

    private String tAvg;

    private String pMin;

    private String pMax;

    private String pAvg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String gettMin() {
        return tMin;
    }

    public void settMin(String tMin) {
        this.tMin = tMin;
    }

    public String gettMax() {
        return tMax;
    }

    public void settMax(String tMax) {
        this.tMax = tMax;
    }

    public String gettAvg() {
        return tAvg;
    }

    public void settAvg(String tAvg) {
        this.tAvg = tAvg;
    }

    public String getpMin() {
        return pMin;
    }

    public void setpMin(String pMin) {
        this.pMin = pMin;
    }

    public String getpMax() {
        return pMax;
    }

    public void setpMax(String pMax) {
        this.pMax = pMax;
    }

    public String getpAvg() {
        return pAvg;
    }

    public void setpAvg(String pAvg) {
        this.pAvg = pAvg;
    }

    public interface MonthContract {

        public String TMIN = "tMin";

        public String TMAX = "tMax";

        public String TAVG = "tAvg";

        public String PMIN = "pMin";

        public String PMAX = "pMax";

        public String PAVG = "pAvg";
    }
}
