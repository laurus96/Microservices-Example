package com.example.restfullapi.service;

import com.example.restfullapi.model.CountryLanguageBean;

import java.util.List;

public interface CountryLanguageService {
    List<CountryLanguageBean> getAllCountryLanguage();
    List<CountryLanguageBean> getCountryLanguagesByName(String countryName);
    CountryLanguageBean getCountryOfficialLanguage(String countryName);
    List<CountryLanguageBean> getCountryNonOfficialLanguage(String countryName);
}
