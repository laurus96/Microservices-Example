package com.example.restfullapi.repository;

import com.example.restfullapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Character[]> {
    @Nullable
    Country findCountryByCode(String code);
    @Nullable
    Country findCountryByName(String name);
    @Nullable
    List<Country> findByIndepYearNotNull(); /* Named Query */
    @Nullable
    List<Country> findByIndepYear(Short year); /* Named Query */
    @Nullable
    List<Country> findByIndepYearBetweenXandY(Short yearOne, Short yearTwo); /* Named Query */


}
