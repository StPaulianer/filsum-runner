package com.filsum.model;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@XmlRootElement
@Table(name = "runner")
public class Runner implements Serializable {


    public enum AgeGroup {
        FEMALE_YOUTH("WU18"), FEMALE("W."), MALE_YOUTH("MU18"), MALE("M."), AMBIGUOUS("U");

        private String text;

        AgeGroup(String text){
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static final String FEMALE = "w";

    public static final String MALE = "m";

    // id
    private Long runnerId;

    // name of the runner
    private String forename;

    // surname
    private String surname;

    // gender of the person (w or m)
    private String gender;

    // e-mail
    private String email;

    private String street;

    private String streetNumber;

    private String city;

    private String zip;

    private String country;

    // size of the shirt
    private String shirt;

    private String club;

    private Integer birthyear;

    private LocalDateTime crts;

    private List<Participation> participation;

    @Id
    @GeneratedValue
    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShirt() {
        return shirt;
    }

    public void setShirt(String shirt) {
        this.shirt = shirt;
    }

    public Integer getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(Integer birthyear) {
        this.birthyear = birthyear;
    }

    @OneToMany(mappedBy = "run", fetch = FetchType.EAGER)
    public List<Participation> getParticipation() {
        return participation;
    }

    public void setParticipation(List<Participation> participation) {
        this.participation = participation;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public LocalDateTime getCrts() {
        return crts;
    }

    public void setCrts(LocalDateTime crts) {
        this.crts = crts;
    }

    @Transient
    public String getCalculateAgeGroup(){
        int birthyearAdult = LocalDate.now().getYear() - 18;
        AgeGroup ageGroup;
        if(gender.equals(FEMALE) && birthyear >= birthyearAdult){
            ageGroup = AgeGroup.FEMALE_YOUTH;
        } else if(gender.equals(FEMALE) && birthyear < birthyearAdult) {
            ageGroup = AgeGroup.FEMALE;
        } else if(gender.equals(MALE) && birthyear >= birthyearAdult) {
            ageGroup = AgeGroup.MALE_YOUTH;
        } else if(gender.equals(MALE) && birthyear < birthyearAdult) {
            ageGroup = AgeGroup.MALE;
        } else {
            ageGroup = AgeGroup.AMBIGUOUS;
        }
        return ageGroup.getText();
    }
}