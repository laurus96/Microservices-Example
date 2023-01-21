package com.example.restfullapi.service;

import com.example.restfullapi.model.CountryBean;

import java.util.List;
public interface CountryService {

    List<CountryBean> getAllCountries();
    CountryBean getCountryByCode(String code);
    CountryBean getCountryByName(String name);
    List<CountryBean> getAllCountryWithIndepYearNotNull();
    List<CountryBean> getAllCountryWithIndepYear(Short year);
    List<CountryBean> getAllCountryWithIndepYearBetweenXandY(Short yearOne, Short yearTwo);

}
