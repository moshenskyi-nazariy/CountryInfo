package com.nazarii_moshenskyi.countryinfo.util;

import com.nazarii_moshenskyi.countryinfo.data.model.Country;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private List<Country> countries;
    private List<Country> fullList;

    public Filter(List<Country> countries) {
        this.countries = countries;
        fullList = new ArrayList<>(countries);
    }

    public List<Country> filter(String input) {
        if (input.isEmpty()) {
            countries.clear();
            countries.addAll(fullList);
            return countries;
        }

        countries.clear();
        for (Country country : fullList) {
            if (country.getName().toLowerCase().contains(input.toLowerCase())) {
                countries.add(country);
            }
        }
        return countries;
    }
}
