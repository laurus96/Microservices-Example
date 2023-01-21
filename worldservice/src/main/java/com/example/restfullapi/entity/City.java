package com.example.restfullapi.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "city")
@NamedQuery(name = "City.getAllCountryCity", query=
        "SELECT city " +
                "FROM City city INNER JOIN Country country ON city.code = country.code " +
                "WHERE country.name = ?1")

public class City implements Serializable {

    @Serial
    private static final long serialVersionUID = 6016031709248020501L;

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", columnDefinition = "char(35)")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    @Column(name = "CountryCode", insertable = false, updatable = false)
    private String code;

    @Column(name = "District", columnDefinition = "char(20)")
    private String district;

    @Column(name = "Population")
    private Integer population;




}
