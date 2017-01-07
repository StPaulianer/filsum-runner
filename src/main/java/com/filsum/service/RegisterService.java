package com.filsum.service;

import com.filsum.model.Participation;
import com.filsum.model.Run;
import com.filsum.model.Runner;
import com.filsum.model.RunnerFormData;
import com.filsum.repository.ParticipationRepository;
import com.filsum.repository.RunRepository;
import com.filsum.repository.RunnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {


    private static final Logger LOG = LoggerFactory.getLogger(RegisterService.class.getName());

    @Autowired
    private RunnerRepository runnerRepository;

    @Autowired
    private RunRepository runRepository;

    @Autowired
    private ParticipationRepository participationRepository;

    @Autowired
    private MailService mailService;

    public Participation createParticipation(RunnerFormData runnerData) throws Exception {
        Runner runnerToSave = runnerData.getRunner();
        runnerToSave.setCrts(LocalDateTime.now());

        Runner runner = runnerRepository.save(runnerToSave);
        Run run = runRepository.findOne(runnerData.getSelectedRun());
        Participation participation = new Participation();
        participation.setRun(run);
        participation.setRunner(runner);
        participation.setCrts(LocalDateTime.now());
        participationRepository.save(participation);

        // create participation for bambini
        // first day of the actual year
        LocalDate actualDate = LocalDate.now();
        LocalDate firstDay = LocalDate.of(actualDate.getYear(), Month.JANUARY, 1);
        // last day of the actual year
        LocalDate lastDay = LocalDate.of(actualDate.getYear(), Month.DECEMBER, 31);

        List<Run> bambiniRun = runRepository.findByStartDateBetweenAndNameLike(firstDay, lastDay, "%ambini%");
        List<Participation> bambinis = new ArrayList<>();
        if(bambiniRun.size() == 1) {
            for (Runner actBambini : runnerData.getFurtherRunners()) {
                if (!actBambini.getForename().isEmpty() && !actBambini.getSurname().isEmpty() && actBambini.getBirthyear() != null) {
                    Runner savedBambini = runnerRepository.save(actBambini);
                    Participation bambiniParticipation = new Participation();
                    bambiniParticipation.setRun(bambiniRun.get(0));
                    bambiniParticipation.setRunner(savedBambini);
                    participationRepository.save(bambiniParticipation);
                    bambinis.add(bambiniParticipation);
                }
            }
        } else {
            LOG.error("No bambini run found or too much...");
        }

        mailService.sendParticpation(participation, bambinis);

        return participation;
    }

    public List<Run> findRunsToRegister(){
        return runRepository.findByparticipationDeadlineAfter(LocalDate.now());
    }

    public List<Run> findRunsForResult(int year){
        // first day of the actual year
        LocalDate firstDay = LocalDate.of(year, Month.JANUARY, 1);
        // last day of the actual year
        LocalDate lastDay = LocalDate.of(year, Month.DECEMBER, 31);

        return runRepository.findByStartDateBetween(firstDay, lastDay);
    }

    public Run findRun(Long runId) {
        return runRepository.findOne(runId);
    }
}
