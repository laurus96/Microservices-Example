package com.example.restfullapi.controller;

import com.example.restfullapi.model.CountryBean;
import com.example.restfullapi.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class CountryController {

    private final CountryService countryService;
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "/countries")
    public List<CountryBean> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping(path = "/country/code={code}")
    public ResponseEntity<CountryBean> getCountryByCode(@PathVariable String code) {

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(countryService.getCountryByCode(code));

        } catch (RuntimeException e){
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/country/name={name}")
    public ResponseEntity<CountryBean> getCountryByName(@PathVariable String name){

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(countryService.getCountryByName(name));

        }catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/country/independent")
    public ResponseEntity<List<CountryBean>> getAllCountryWithIndepYear(){

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(countryService.getAllCountryWithIndepYearNotNull());
        } catch (RuntimeException e){
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/country/independent={year}")
    public ResponseEntity<List<CountryBean>> getAllCountryWithIndepYear(@PathVariable String year){

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(countryService.getAllCountryWithIndepYear(Short.decode(year)));
        } catch (RuntimeException e){
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/country/independentBetween={yearOne}and{yearTwo}")
    public ResponseEntity<List<CountryBean>> getAllCountryWithIndepYearBetweenXandY(
            @PathVariable(name = "yearOne") String yearOne,
            @PathVariable(name = "yearTwo") String yearTwo
    ){

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(countryService.getAllCountryWithIndepYearBetweenXandY(Short.decode(yearOne), Short.decode(yearTwo)));
        } catch (RuntimeException e){
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @RequestMapping(path = "/country/countryName={countryName}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> isCountryInDatabase(@PathVariable String countryName) {

        try {
            if (!Objects.isNull(countryService.getCountryByName(countryName))) {
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }


}
