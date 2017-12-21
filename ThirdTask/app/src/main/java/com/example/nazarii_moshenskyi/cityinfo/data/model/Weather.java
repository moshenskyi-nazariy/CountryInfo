
package com.example.nazarii_moshenskyi.cityinfo.data.model;

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
}
