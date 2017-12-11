package com.example.nazarii_moshenskyi.cityinfo.data;

import com.example.nazarii_moshenskyi.cityinfo.data.model.Country;

import java.util.List;

public interface IRepository {
    List<Country> getCountries();
}
