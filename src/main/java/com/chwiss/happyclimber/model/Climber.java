package com.chwiss.happyclimber.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity(name="climber")
@Table(name="climber")
public class Climber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_climber")
    @SequenceGenerator(name = "seq_climber", allocationSize = 1)
    private Long id;
    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String firstname;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    @NotNull
    private Date birthday;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty
    @NotNull
    private String password;

    public String getLiving() {
        return living;
    }

    public void setLiving(String living) {
        this.living = living;
    }

    @NotEmpty
    @NotNull
    private String living;

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @NotEmpty
    @NotNull
    private String nation;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }



    public Climber() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    @NotNull
    private String name;

    /**
     *
     * @param username Name vom User, wird für das Login benutzt
     * @param firstname Vorname
     * @param name Nachname
     */
    public Climber(@NotEmpty @NotNull String username, @NotEmpty @NotNull String firstname, @NotEmpty @NotNull String name) {
        this.username = username;
        this.firstname = firstname;
        this.name = name;
    }
}
