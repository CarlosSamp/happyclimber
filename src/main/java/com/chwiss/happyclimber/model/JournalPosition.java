package com.chwiss.happyclimber.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "journalpos")
@Table(name="journalpos")
public class JournalPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_journalpos")
    @SequenceGenerator(name = "seq_journalpos", allocationSize = 1)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotNull
    private Date date;

    @Enumerated(EnumType.STRING)
    private Ascent ascent;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "routeFk")
    private Route route;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "climberFk")
    private Climber climber;

    /**
     *
     * @param date An welches Datum geklettert wurde
     * @param ascent Wie geklettert wurde, Begehungsstil
     * @param route welche Route geklettert wurde
     */
    public JournalPosition(@NotNull Date date, Ascent ascent, Route route) {
        this.date = date;
        this.ascent = ascent;
        this.route = route;
    }

    public JournalPosition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Enum getAscent() {
        return ascent;
    }

    public void setAscent(Ascent ascent) {

        this.ascent = ascent;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

  public Climber getClimber() {
        return climber;
    }

    public void setClimber(Climber climber) {
        this.climber = climber;
    }
}
