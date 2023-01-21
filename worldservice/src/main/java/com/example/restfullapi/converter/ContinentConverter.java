package com.example.restfullapi.converter;

import com.example.restfullapi.enumeration.Continent;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ContinentConverter implements AttributeConverter<Continent, String> {
    @Override
    public String convertToDatabaseColumn(Continent continent) {
        return continent.getName();
    }

    @Override
    public Continent convertToEntityAttribute(String s) {

        if (s.compareTo("Asia") == 0) return Continent.ASIA;
        if (s.compareTo("Europe") == 0) return Continent.EUROPE;
        if (s.compareTo("North America") == 0) return Continent.NORTH_AMERICA;
        if (s.compareTo("Africa") == 0) return Continent.AFRICA;
        if (s.compareTo("Oceania") == 0) return Continent.OCEANIA;
        if(s.compareTo("Antarctica") == 0) return Continent.ANTARCTICA;

        return  Continent.SOUTH_AMERICA;
    }
}
