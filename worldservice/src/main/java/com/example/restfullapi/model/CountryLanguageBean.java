package com.example.restfullapi.model;

import com.example.restfullapi.enumeration.CountryOfficialLanguage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguageBean {

    private String countryCode;

    private String language;

    @JsonProperty("country")
    private CountryBean countryBean;

    @JsonProperty("is_Official?")
    private CountryOfficialLanguage isOfficial;

    @JsonProperty("spokenPercentage")
    private BigDecimal percentage;
}
