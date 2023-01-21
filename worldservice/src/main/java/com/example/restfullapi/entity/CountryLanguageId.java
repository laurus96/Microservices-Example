package com.example.restfullapi.entity;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CountryLanguageId implements Serializable {

    @Serial
    private static final long serialVersionUID = -5927198656564618304L;

    private String countryCode;
    private String language;

}
