package com.example.restfullapi.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CountryOfficialLanguage {
    TRUE("T"),
    FALSE("F");

    private final String value;

}
