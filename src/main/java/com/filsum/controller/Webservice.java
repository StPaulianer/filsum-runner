package com.filsum.controller;

import com.filsum.model.Participation;
import com.filsum.model.Run;
import com.filsum.service.ParticipationService;
import com.filsum.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class Webservice {

    private static final Logger LOG = LoggerFactory.getLogger(Webservice.class.getName());


    @Autowired
    private ParticipationService participationService;

    @Autowired
    private RegisterService registerService;

    /**
     * shows the paid participants of runs of the actual year
     */
    @RequestMapping(value = "/service/runner/{participationId}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Participation> getRunnerInfo(@PathVariable("participationId") final Long participationId) {
        LOG.debug("run info for " +participationId);

        Participation participation = participationService.findById(participationId);

        ResponseEntity<Participation> entity = new ResponseEntity(participation, HttpStatus.OK);

        return entity;
    }

    /**
     * shows the paid participants of runs of the actual year
     */
    @RequestMapping(value = "/service/runner", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<Participation>> getAllRunnerInfo() {
        LOG.debug("all runner info");

        LocalDate actualDate = LocalDate.now();
        List<Participation> participations = participationService.findActualPaidParticipants(actualDate.getYear());

        ResponseEntity<List<Participation>> entity = new ResponseEntity(participations, HttpStatus.OK);

        return entity;
    }

    /**
     * shows the paid participants of runs of the actual year
     */
    @RequestMapping(value = "/service/run/{runId}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<List<Participation>> getAllRunnerForRun(@PathVariable("runId") final Long runId) {
        LOG.debug("all runner for run");

        List<Participation> participations = participationService.findParticipantsByRun(runId);

        ResponseEntity<List<Participation>> entity = new ResponseEntity(participations, HttpStatus.OK);

        return entity;
    }

    /**
     * shows the paid participants of runs of the actual year
     */
    @RequestMapping(value = "/service/csv")
    public ResponseEntity getAllRunnerAsCSV() {
        LOG.debug("all runner as csv");

        StringBuilder data = new StringBuilder();

        // header
        data.append("'Startnummer',");
        data.append("'Nachname',");
        data.append("'Vorname',");
        data.append("'Geschlecht',");
        data.append("'Geburtsjahr',");
        data.append("'Altersklasse',");
        data.append("'Verein',");
        data.append("'T-Shirt',");
        data.append("'Lauf'\n");


        LocalDate actualDate = LocalDate.now();
        List<Participation> participations = participationService.findActualPaidParticipants(actualDate.getYear());

        for(Participation participation : participations){
            data.append("'" + participation.getStartnumber() +"',");
            data.append("'" + participation.getRunner().getSurname() +"',");
            data.append("'" + participation.getRunner().getForename() +"',");
            data.append("'" + participation.getRunner().getGender() +"',");
            data.append("'" + participation.getRunner().getBirthyear() +"',");
            data.append("'" + participation.getRunner().getCalculateAgeGroup()+"',");
            data.append("'" + participation.getRunner().getClub() +"',");
            data.append("'" + participation.getRunner().getShirt() +"',");
            data.append("'" + participation.getRun().getName() +"'\n");
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Disposition", "attachment; filename=exportFilsumLoeppt.csv");


        return new ResponseEntity<>(data.toString(), responseHeaders, HttpStatus.OK);
    }
}
