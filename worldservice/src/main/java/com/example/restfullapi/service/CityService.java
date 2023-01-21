package com.example.restfullapi.service;

import com.example.restfullapi.model.CityBean;

import java.util.List;

public interface CityService {
    CityBean getCityByName(String name);
    List<CityBean> getCityAll();
    List<CityBean> getAllCityByCountryName(String countryName);
}
