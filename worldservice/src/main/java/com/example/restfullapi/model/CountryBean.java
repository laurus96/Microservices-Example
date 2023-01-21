package com.example.restfullapi.model;

import com.example.restfullapi.enumeration.Continent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryBean {

    @JsonProperty("countryCode")
    private String code;

    @JsonProperty("countryName")
    private String name;

    @JsonProperty("countryContinent")
    private Continent continent;

    @JsonProperty("countryRegion")
    private String region;

    @JsonProperty("countrySurfaceArea")
    private BigDecimal surfaceArea;

    @JsonProperty("independentYear")
    private Short indepYear;

    @JsonProperty("countryPopulation")
    private Integer population;

    @JsonProperty("countryLifeExpectancy")
    private BigDecimal lifeExpectancy;

    @JsonProperty("countryGnp")
    private BigDecimal gnp;

    @JsonProperty("countryGnpOld")
    private BigDecimal gnpOld;

    @JsonProperty("countryLocalName")
    private String localName;

    @JsonProperty("countryGovernmentForm")
    private String governmentForm;

    @JsonProperty("countryHeadOfState")
    private String headOfState;

    @JsonProperty("countryCapital")
    private Integer capital;

    @JsonProperty("countryAlternativeCode")
    private String code2;

}
