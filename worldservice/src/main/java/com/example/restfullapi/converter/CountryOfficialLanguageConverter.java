package com.example.restfullapi.converter;

import com.example.restfullapi.enumeration.CountryOfficialLanguage;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CountryOfficialLanguageConverter implements AttributeConverter<CountryOfficialLanguage, String> {
    @Override
    public String convertToDatabaseColumn(CountryOfficialLanguage countryOfficialLanguage) {
        return countryOfficialLanguage.getValue();
    }

    @Override
    public CountryOfficialLanguage convertToEntityAttribute(String s) {
        if(s.compareTo("T") == 0) return CountryOfficialLanguage.TRUE;
        return CountryOfficialLanguage.FALSE;
    }
}
