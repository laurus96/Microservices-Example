package com.example.restfullapi.service;

import com.example.restfullapi.entity.CountryLanguage;
import com.example.restfullapi.model.CountryBean;
import com.example.restfullapi.model.CountryLanguageBean;
import com.example.restfullapi.repository.CountryLanguageRepository;
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
public class CountryLanguageServiceImplementation implements CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    @Autowired
    public CountryLanguageServiceImplementation(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    private List<CountryLanguageBean> toListCountryLanguageBean(List<CountryLanguage> countryLanguages){
        if(!CollectionUtils.isEmpty(countryLanguages)) {
            List<CountryLanguageBean> countryLanguageBeans = new ArrayList<>();

            countryLanguages.forEach(countryLanguage -> {
                CountryLanguageBean countryLanguageBean = new CountryLanguageBean();
                BeanUtils.copyProperties(countryLanguage, countryLanguageBean);
                if(!Objects.isNull(countryLanguage.getCountry())){
                    CountryBean countryBean = new CountryBean();
                    BeanUtils.copyProperties(countryLanguage.getCountry(), countryBean);
                    countryLanguageBean.setCountryBean(countryBean);
                }

                countryLanguageBeans.add(countryLanguageBean);
            });

            return countryLanguageBeans;
        }

        return null;
    }

    private CountryLanguageBean toCountryLanguageBean(CountryLanguage countryLanguage){
        if(!Objects.isNull(countryLanguage)){
            CountryLanguageBean countryLanguageBean = new CountryLanguageBean();

            BeanUtils.copyProperties(countryLanguage, countryLanguageBean);
            if(!Objects.isNull(countryLanguage.getCountry())){
                CountryBean countryBean = new CountryBean();
                BeanUtils.copyProperties(countryLanguage.getCountry(), countryBean);
                countryLanguageBean.setCountryBean(countryBean);
            }

            return countryLanguageBean;
        }

        return null;
    }

    @Override
    public List<CountryLanguageBean> getAllCountryLanguage() {
        log.info("Fetching Languages ...");
        try {

            return toListCountryLanguageBean(countryLanguageRepository.findAll());

        }catch (RuntimeException e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<CountryLanguageBean> getCountryLanguagesByName(String countryName){
        log.info("Fetching all spoken languages for {} ...", countryName);

        try {

            return toListCountryLanguageBean(countryLanguageRepository.findSpokenLanguage(countryName));

        }catch (RuntimeException e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public CountryLanguageBean getCountryOfficialLanguage(String countryName) {
        log.info("Fetching official Language for {} ...", countryName);
        try {

            return toCountryLanguageBean(countryLanguageRepository.findOfficialLanguage(countryName));

        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<CountryLanguageBean> getCountryNonOfficialLanguage(String countryName){
        log.info("Fetching non official Language for {} ...", countryName);
        try {

            return toListCountryLanguageBean(countryLanguageRepository.findNonOfficialLanguage(countryName));

        } catch (RuntimeException e){
            log.error(e.getMessage());
            return null;
        }
    }

}
