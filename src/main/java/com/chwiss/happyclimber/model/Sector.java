package com.chwiss.happyclimber.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name="sector")
@Table(name="sector")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_sector")
    @SequenceGenerator(name = "seq_sector", allocationSize = 2)
    private Long id;

    @NotEmpty
    @NotNull
    private String name;

    @NotEmpty
    @NotNull
    private String place;

    @NotEmpty
    @NotNull
    private String country;

    public Sector() {
    }

    /**
     *
     * @param name Name der Sektor
     * @param place Ort vom Sektor
     * @param country Land vom Sektor
     */
    public Sector(@NotEmpty @NotNull String name, @NotEmpty @NotNull String place, @NotEmpty @NotNull String country) {
        this.name = name;
        this.place = place;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
