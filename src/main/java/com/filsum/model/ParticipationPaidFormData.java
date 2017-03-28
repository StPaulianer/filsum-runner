package com.filsum.model;


import java.util.ArrayList;
import java.util.List;

public class ParticipationPaidFormData {


    private List<Participation> participants = new ArrayList<>();

    public ParticipationPaidFormData() {
    }

    public ParticipationPaidFormData(List<Participation> participants) {
        this.participants = participants;
    }

    public List<Participation> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participation> participants) {
        this.participants = participants;
    }

}
