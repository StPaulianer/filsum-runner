package com.filsum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@XmlRootElement
@Table(name = "participation")
public class Participation implements Serializable {

    // id
    private Long participationId;

    private String runtime;

    private boolean paid = false;

    private boolean hasPaid = false;

    private String startnumber;

    private LocalDateTime crts;

    private Run run;

    private Runner runner;

    @Id
    @GeneratedValue
    public Long getParticipationId() {
        return participationId;
    }

    public void setParticipationId(Long participationId) {
        this.participationId = participationId;
    }


    @ManyToOne
    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }

    @ManyToOne
    public Runner getRunner() {
        return runner;
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getStartnumber() {
        return startnumber;
    }

    public void setStartnumber(String startnumber) {
        this.startnumber = startnumber;
    }

    public LocalDateTime getCrts() {
        return crts;
    }

    public void setCrts(LocalDateTime crts) {
        this.crts = crts;
    }

    @JsonIgnore
    @Transient
    public boolean getHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }


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

    public enum AgeGroupYouth {
        FEMALE_8("WU8"), FEMALE_10("WU10"), FEMALE_12("WU12"), FEMALE_14("WU14"), FEMALE_16("WU16"), FEMALE_18("WU18"),
        MALE_8("MU8"), MALE_10("MU10"), MALE_12("MU12"), MALE_14("MU14"), MALE_16("MU16"), MALE_18("MU18");

        private String text;

        AgeGroupYouth(String text){
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }


    @Transient
    public String getCalculateAgeGroup(){

        if(getRun().getName().contains("Bambini")) {
            return "Bambinis";
        } else if(getRun().getName().contains("Schülerlauf")) {
            AgeGroupYouth ageGroup;
            if(runner.getGender().equals(runner.FEMALE)){
                if(runner.getBirthyear() >= 16){
                    ageGroup = AgeGroupYouth.FEMALE_18;
                } else if(runner.getBirthyear() < 16 && runner.getBirthyear() >= 14) {
                    ageGroup = AgeGroupYouth.FEMALE_16;
                } else if(runner.getBirthyear() < 14 && runner.getBirthyear() >= 12) {
                    ageGroup = AgeGroupYouth.FEMALE_14;
                } else if(runner.getBirthyear() < 12 && runner.getBirthyear() >= 10) {
                    ageGroup = AgeGroupYouth.FEMALE_12;
                } else if(runner.getBirthyear() < 10 && runner.getBirthyear() >= 8) {
                    ageGroup = AgeGroupYouth.FEMALE_10;
                } else {
                    ageGroup = AgeGroupYouth.FEMALE_8;
                }
            } else {
                if(runner.getBirthyear() >= 16){
                    ageGroup = AgeGroupYouth.MALE_18;
                } else if(runner.getBirthyear() < 16 && runner.getBirthyear() >= 14) {
                    ageGroup = AgeGroupYouth.MALE_16;
                } else if(runner.getBirthyear() < 14 && runner.getBirthyear() >= 12) {
                    ageGroup = AgeGroupYouth.MALE_14;
                } else if(runner.getBirthyear() < 12 && runner.getBirthyear() >= 10) {
                    ageGroup = AgeGroupYouth.MALE_12;
                } else if(runner.getBirthyear() < 10 && runner.getBirthyear() >= 8) {
                    ageGroup = AgeGroupYouth.MALE_10;
                } else {
                    ageGroup = AgeGroupYouth.MALE_8;
                }
            }

            return ageGroup.getText();
        } else {
            int birthyearAdult = LocalDate.now().getYear() - 18;
            AgeGroup ageGroup;
            if(runner.getGender().equals(runner.FEMALE) && runner.getBirthyear() >= birthyearAdult){
                ageGroup = AgeGroup.FEMALE_YOUTH;
            } else if(runner.getGender().equals(runner.FEMALE) && runner.getBirthyear() < birthyearAdult) {
                ageGroup = AgeGroup.FEMALE;
            } else if(runner.getGender().equals(runner.MALE) && runner.getBirthyear() >= birthyearAdult) {
                ageGroup = AgeGroup.MALE_YOUTH;
            } else if(runner.getGender().equals(runner.MALE) && runner.getBirthyear() < birthyearAdult) {
                ageGroup = AgeGroup.MALE;
            } else {
                ageGroup = AgeGroup.AMBIGUOUS;
            }
            return ageGroup.getText();
        }
    }
}