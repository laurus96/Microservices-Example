package com.example.restfullapi.entity;

import com.example.restfullapi.enumeration.Continent;
import com.example.restfullapi.converter.ContinentConverter;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "country")
@NamedQuery(name = "Country.findByIndepYearNotNull", query =
        "SELECT country " +
                "FROM Country country " +
                "WHERE country.indepYear IS NOT NULL ")

@NamedQuery(name = "Country.findByIndepYear", query =
        "SELECT country " +
                "FROM Country country " +
                "WHERE country.indepYear > ?1 ")

@NamedQuery(name =  "Country.findByIndepYearBetweenXandY", query =
        "SELECT country " +
                "FROM Country country " +
                "WHERE country.indepYear BETWEEN ?1 AND ?2")

public class Country implements Serializable {

    @Serial
    private static final long serialVersionUID = -9049683190111994959L;

    @Id
    @Column(name = "Code", columnDefinition = "char(3)")
    private String code;

    @Column(name = "Name", columnDefinition = "char(52)")
    private String name;

    @Column(name = "Continent", columnDefinition = "enum('Asia', 'Europe', 'North America', 'Africa', 'Oceania', 'Antarctica', 'South America')")
    @Convert(converter = ContinentConverter.class)
    private Continent continent;

    @Column(name = "Region", columnDefinition = "char(26)")
    private String region;

    @Column(name = "SurfaceArea", columnDefinition = "Decimal(10,2)")
    private BigDecimal surfaceArea;
    @Column(name = "IndepYear")
    private Short indepYear;

    @Column(name = "Population")
    private Integer population;

    @Column(name = "LifeExpectancy", columnDefinition = "Decimal(3,1)")
    private BigDecimal lifeExpectancy;

    @Column(name = "GNP", columnDefinition = "Decimal(10,2)")
    private BigDecimal gnp;

    @Column(name = "GNPOld", columnDefinition = "Decimal(10,2)")
    private BigDecimal gnpOld;

    @Column(name = "LocalName", columnDefinition = "char(45)")
    private String localName;

    @Column(name = "GovernmentForm", columnDefinition = "char(45)")
    private String governmentForm;

    @Column(name = "HeadOfState", columnDefinition = "char(60)")
    private String headOfState;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2", columnDefinition = "char(2)")
    private String code2;

}
