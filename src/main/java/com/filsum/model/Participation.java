package com.filsum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
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
}