package com.example.restfullapi.controller;

import com.example.restfullapi.service.CityService;
import com.example.restfullapi.model.CityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(path = "/name={name}")
    public CityBean getCityByName(@PathVariable(name = "name") String name){
        return cityService.getCityByName(name);
    }

    @GetMapping
    public List<CityBean> getCityAll(){
        return cityService.getCityAll();
    }

    @GetMapping(path = "/countryName={countryName}")
    public List<CityBean> getAllCityByCountryName(@PathVariable String countryName){
        return cityService.getAllCityByCountryName(countryName);
    }

}
