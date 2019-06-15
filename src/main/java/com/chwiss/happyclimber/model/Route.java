package com.chwiss.happyclimber.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity(name="route")
@Table(name="route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_route")
    @SequenceGenerator(name = "seq_route", allocationSize = 1)
    private Long id;
    @NotEmpty
    @NotNull
    private String name;

    //mit EnumType.STRING - Enum nicht 0 oder 1 sondern MR oder MRS
    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Route() {

    }

    /**
     *
     * @param name Name der Route
     * @param grade Schwierigkeitsgrad der Route
     * @param sector In welchen Sektor befindet sich die Route
     */
    public Route(@NotEmpty @NotNull String name, Grade grade, Sector sector) {
        this.name = name;
        this.grade = grade;
        this.sector = sector;
    }

    public Sector getSector() {

        return sector;
    }

    public void setSector(Sector sector) {

        this.sector = sector;
    }

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "sectorFk")
    private Sector sector;

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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }


}
