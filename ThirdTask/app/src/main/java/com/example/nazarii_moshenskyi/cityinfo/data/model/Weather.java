
package com.example.nazarii_moshenskyi.cityinfo.data.model;

import android.support.annotation.StringDef;

import java.util.ArrayList;
import java.util.List;

public class Weather {

    private List<Month> months = null;

    public Weather() {
        months = new ArrayList<>();
    }

    public List<Month> getMonths() {
        return months;
    }

    public void addMonth(Month month) {
        months.add(month);
    }

    private static final String JANUARY = "january";
    private static final String FEBRUARY = "february";
    private static final String MARCH = "march";
    private static final String APRIL = "april";
    private static final String MAY = "may";
    private static final String JUNE = "june";
    private static final String JULY = "july";
    private static final String AUGUST = "august";
    private static final String SEPTEMBER = "august";
    private static final String NOVEMBER = "november";
    private static final String DECEMBER = "december";
    @StringDef({JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, NOVEMBER, DECEMBER})
    public @interface Months {}
}
