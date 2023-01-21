package com.example.restfullapi.service;

import com.example.restfullapi.model.CountryBean;
import com.example.restfullapi.entity.City;
import com.example.restfullapi.model.CityBean;
import com.example.restfullapi.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@Transactional(readOnly = true)
public class CityServiceImplementation implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImplementation(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    private List<CityBean> toListCityBean(List<City> cities){
        if(!CollectionUtils.isEmpty(cities)) {
            List<CityBean> citiesBean = new ArrayList<>();

            cities.forEach(city -> {
                CityBean cityBean = new CityBean();
                BeanUtils.copyProperties(city, cityBean);
                if (!Objects.isNull(city.getCountry())) {
                    CountryBean countryBean = new CountryBean();
                    BeanUtils.copyProperties(city.getCountry(), countryBean);
                    cityBean.setCountry(countryBean);
                }
                citiesBean.add(cityBean);
            });
            return citiesBean;
        }
        return null;
    }

    private CityBean toCityBean(City city){
        if(!Objects.isNull(city)){
            CityBean cityBean = new CityBean();
            BeanUtils.copyProperties(city, cityBean);
            if(!Objects.isNull(city.getCountry())){
                CountryBean countryBean = new CountryBean();
                BeanUtils.copyProperties(city.getCountry(), countryBean);
                cityBean.setCountry(countryBean);
            }
            return cityBean;
        }
        return null;
    }

    @Override
    public CityBean getCityByName(String name) {
        log.info("Fetching city, name = {} ...", name);
        City city = cityRepository.findByName(name);
        if(!Objects.isNull(city)){
            return toCityBean(city);
        }
        return null;
    }

    @Override
    public List<CityBean> getCityAll() {
        log.info("Fetching cities ...");

        List<City> cities = cityRepository.findAll();

        if(!CollectionUtils.isEmpty(cities)){
            try {
                return toListCityBean(cities);
            }catch (RuntimeException e){
                log.error(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public List<CityBean> getAllCityByCountryName(String countryName) {
        log.info("Fetching cities in {}", countryName);
        try {

            return toListCityBean(cityRepository.getAllCountryCity(countryName));

        }catch (RuntimeException e){
            log.info(e.getMessage());
        }
        return null;
    }
}
