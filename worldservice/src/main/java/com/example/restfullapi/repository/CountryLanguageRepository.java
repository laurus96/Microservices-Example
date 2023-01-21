package com.example.restfullapi.repository;


import com.example.restfullapi.entity.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, String> {
    @Nullable
    List<CountryLanguage> findSpokenLanguage(String countryName);
    @Nullable
    CountryLanguage findOfficialLanguage(String countryName);
    @Nullable
    List<CountryLanguage> findNonOfficialLanguage(String countryName);
}
