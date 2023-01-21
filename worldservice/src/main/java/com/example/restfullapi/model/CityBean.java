package com.example.restfullapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityBean {

    @JsonProperty("idCity")
    private Integer id;

    @JsonProperty("nameCity")
    private String name;

    @JsonProperty("countryCity")
    private CountryBean country;

    @JsonProperty("countryCodeCity")
    private String countryCode;

    @JsonProperty("districtCity")
    private String district;

    @JsonProperty("populationCity")
    private Integer population;
}
