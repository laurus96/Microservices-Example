package com.example.restfullapi.service;

import com.example.restfullapi.entity.Country;
import com.example.restfullapi.model.CountryBean;
import com.example.restfullapi.repository.CountryRepository;
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
@Transactional(readOnly = true)
@Slf4j
public class CountryServiceImplementation implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    private List<CountryBean> toCountryBean(List<Country> countries){
        List<CountryBean> countriesBean = new ArrayList<>();

        countries.stream().forEach(country -> {
            CountryBean tempCountryBean = new CountryBean();
            BeanUtils.copyProperties(country, tempCountryBean);
            countriesBean.add(tempCountryBean);
        });

        return countriesBean;

    }

    @Override
    public List<CountryBean> getAllCountries() {
        log.info("Fetching all Countries in the Database...");

        List<Country> fetchedCountry = countryRepository.findAll();

        if (!CollectionUtils.isEmpty(fetchedCountry)){
            log.info("Founded {} Countries", fetchedCountry.size());

            try {

                return toCountryBean(fetchedCountry);

            } catch (RuntimeException e) {
                log.error(e.getMessage());

            }
        }
        return null;

    }

    @Override
    public CountryBean getCountryByCode(String code) {
        log.info("Fetching Country in the Database with Code {} ...", code);

        Country foundedCountry = countryRepository.findCountryByCode(code);
        if (Objects.isNull(foundedCountry)) {
            log.error("Country {} not found in the database", code);
            throw new RuntimeException("Country not found");
        }

        CountryBean countryBean = new CountryBean();
        BeanUtils.copyProperties(foundedCountry, countryBean);
        return countryBean;
    }

    @Override
    public CountryBean getCountryByName(String name) {
        log.info("Fetching Country in the Database with Name {} ...", name);

        Country foundedCountry = countryRepository.findCountryByName(name);
        if (Objects.isNull(foundedCountry)){
            log.error("Country {} not found in the database", name);
            throw new RuntimeException("Country not found");

        }

        CountryBean countryBean = new CountryBean();
        BeanUtils.copyProperties(foundedCountry, countryBean);
        return countryBean;

    }

    @Override
    public List<CountryBean> getAllCountryWithIndepYearNotNull() {
        log.info("Fetching Countries in the Database with an independent year not null ...");

        List<Country> fetchedCountry = countryRepository.findByIndepYearNotNull();

        if(!Objects.isNull(fetchedCountry)){
            log.info("Founded {} Countries with an independent date", fetchedCountry.size());

            try {

                return toCountryBean(fetchedCountry);

            }catch (RuntimeException e){
                log.error(e.getMessage());
            }
        }

        return null;
    }

    @Override
    public List<CountryBean> getAllCountryWithIndepYear(Short year) {
        log.info("Fetching Countries in the Database with an independent year > {}  ...", year);

        List<Country> fetchedCountry = countryRepository.findByIndepYear(year);

        if(!Objects.isNull(fetchedCountry)){
            log.info("Founded {} Countries with an independent date", fetchedCountry.size());

            try {

                return  toCountryBean(fetchedCountry);

            } catch (RuntimeException e) {
                log.error(e.getMessage());
            }
        }

        return null;
    }

    @Override
    public List<CountryBean> getAllCountryWithIndepYearBetweenXandY(Short yearOne, Short yearTwo) {
        log.info("Fetching Countries in the Database with an independent date between {} and {} ...", yearOne, yearTwo);

        List<Country> fetchedCountry = countryRepository.findByIndepYearBetweenXandY(yearOne, yearTwo);

        if (!Objects.isNull(fetchedCountry)){
            log.info("Founded {} Countries with an independent date between {} and {}",
                    fetchedCountry.size(),
                    yearOne,
                    yearTwo);

            try {

                return toCountryBean(fetchedCountry);

            } catch (RuntimeException e){
                log.error(e.getMessage());
            }
        }

        return null;
    }
}
