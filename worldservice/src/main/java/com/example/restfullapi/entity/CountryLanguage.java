package com.example.restfullapi.entity;

import com.example.restfullapi.enumeration.CountryOfficialLanguage;
import com.example.restfullapi.converter.CountryOfficialLanguageConverter;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "countrylanguage")
@IdClass(CountryLanguageId.class)
@NamedQuery(name = "CountryLanguage.findSpokenLanguage", query =
        "SELECT countrylanguage " +
                "FROM CountryLanguage countrylanguage " +
                "JOIN Country country ON countrylanguage.countryCode = country.code " +
                "WHERE country.name = ?1")

@NamedQuery(name = "CountryLanguage.findOfficialLanguage", query =
        "SELECT countrylanguage " +
                "FROM CountryLanguage countrylanguage " +
                "JOIN Country country ON countrylanguage.countryCode = country.code " +
                "WHERE countrylanguage.isOfficial = 'T' and country.name = ?1")

@NamedQuery(name = "CountryLanguage.findNonOfficialLanguage", query =
        "SELECT countrylanguage " +
                "FROM CountryLanguage countrylanguage " +
                "JOIN Country country ON countrylanguage.countryCode = country.code " +
                "WHERE countrylanguage.isOfficial = 'F' and country.name = ?1")



public class CountryLanguage implements Serializable {

    @Serial
    private static final long serialVersionUID = 8110207317223583914L;
    @Id
    @Column(name = "CountryCode", insertable = false, updatable = false)
    private String countryCode;

    @Id
    @Column(name = "Language")
    private String language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    @Column(name = "IsOfficial", columnDefinition = "enum('T', 'F')")
    @Convert(converter = CountryOfficialLanguageConverter.class)
    private CountryOfficialLanguage isOfficial;

    @Column(name = "Percentage", columnDefinition = "decimal(4,1)")
    private BigDecimal percentage;

}
