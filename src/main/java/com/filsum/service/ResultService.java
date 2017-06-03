package com.filsum.service;

import com.filsum.model.Participation;
import com.filsum.model.Run;
import com.filsum.repository.ParticipationRepository;
import com.filsum.repository.RunRepository;
import com.filsum.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class ResultService {



    @Autowired
    private ParticipationRepository participationRepository;


    public void saveResult(List<Participation> participations){
        for (Participation participation : participations) {
            Participation dbParticipation = participationRepository.findOne(participation.getParticipationId());
            if(participation.getRuntime().isEmpty()){
                dbParticipation.setRuntime(null);
            } else {
                dbParticipation.setRuntime(participation.getRuntime());
            }
            dbParticipation.setStartnumber(participation.getStartnumber());
            participationRepository.save(dbParticipation);
        }
    }

    public boolean saveResult(Long participationId, String result, String startnumber) {
        Participation existingPart = participationRepository.findOne(participationId);

        if(existingPart != null){
            existingPart.setRuntime(result.trim());
            existingPart.setStartnumber(startnumber.trim());
            participationRepository.save(existingPart);
            return true;
        }

        return false;

    }

}
