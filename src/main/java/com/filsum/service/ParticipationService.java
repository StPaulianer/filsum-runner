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
public class ParticipationService {

    @Autowired
    private RunnerRepository runnerRepository;

    @Autowired
    private RunRepository runRepository;

    @Autowired
    private ParticipationRepository participationRepository;

    public List<Participation> findParticipants(){
        return participationRepository.findAll();
    }


    public List<Participation> findParticipantsWithResults(){
        return participationRepository.findByRuntimeIsNotNull();
    }

    public List<Participation> findParticipantsWithResults(Long runId){
        Run run = runRepository.findOne(runId);
        return participationRepository.findByRuntimeIsNotNullAndRun(run);
    }

    /**
     *
     * @param year actual year
     * @return
     */
    public List<Participation> findActualPaidParticipants(int year){

        // first day of the actual year
        LocalDate firstDay = LocalDate.of(year, Month.JANUARY, 1);
        // last day of the actual year
        LocalDate lastDay = LocalDate.of(year, Month.DECEMBER, 31);

        List<Run> runsOfYear = runRepository.findByStartDateBetween(firstDay, lastDay);
        return participationRepository.findByRunInAndPaid(runsOfYear, true);
    }

    /**
     *
     * @param year actual year
     * @return
     */
    public List<Participation> findActualRegistered(int year){

        // first day of the actual year
        LocalDate firstDay = LocalDate.of(year, Month.JANUARY, 1);
        // last day of the actual year
        LocalDate lastDay = LocalDate.of(year, Month.DECEMBER, 31);

        List<Run> runsOfYear = runRepository.findByStartDateBetween(firstDay, lastDay);
        return participationRepository.findByRunInOrderByParticipationId(runsOfYear);
    }

    public void savePayStatus(List<Participation> participations){
        for (Participation participation : participations) {
            if(participation.getHasPaid() && participation.getParticipationId() != null){
                Participation dbParticipation = participationRepository.findOne(participation.getParticipationId());
                dbParticipation.setPaid(true);
                participationRepository.save(dbParticipation);
            }
        }
    }
}
