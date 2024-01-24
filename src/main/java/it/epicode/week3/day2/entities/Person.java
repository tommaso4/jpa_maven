package it.epicode.week3.day2.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private EGenres genres;
    @OneToOne
    @JoinColumn(name = "participation_id")
    private Participation participation;

    public Person() {
    }

    public Person(String name, String surname, String email, LocalDate dateOfBirth, EGenres genres) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", genres=" + genres +
                ", partacipationList=" + participation +
                '}';
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public EGenres getGenres() {
        return genres;
    }

    public void setGenres(EGenres genres) {
        this.genres = genres;
    }

    public Participation getParticipationList() {
        return participation;
    }

    public void setParticipationList(Participation partacipationList) {
        this.participation = partacipationList;
    }
}

