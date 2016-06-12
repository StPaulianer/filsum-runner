package com.filsum.controller;

import com.filsum.model.Participation;
import com.filsum.model.Run;
import com.filsum.service.ParticipationService;
import com.filsum.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ParticipationController {

    private static final Logger LOG = LoggerFactory.getLogger(ParticipationController.class.getName());


    @Autowired
    private ParticipationService participationService;

    @Autowired
    private RegisterService registerService;

    /**
     * shows the paid participants of runs of the actual year
     */
    @RequestMapping(value = "/participantslist")
    public String participantView(Model model) {
        LOG.debug("participants list");
        System.out.println("participants list start");

        LocalDate actualDate = LocalDate.now();
        List<Participation> particpiants = participationService.findActualPaidParticipants(actualDate.getYear());
        model.addAttribute("participants", particpiants);

        System.out.println("participants list end");
        return "startlist";
    }

    @RequestMapping(value = "/results")
    public String resultsView(Model model) {
        LOG.debug("results list");
        LocalDate actualDate = LocalDate.now();
        List<Run> runs = registerService.findRunsForResult(actualDate.getYear());
        List<Run> runsForResult = runs.stream().filter(b -> b.isShowResult()).collect(Collectors.toList());

        if (runsForResult.size() > 0) {
            return "redirect:results/" + runsForResult.get(0).getRunId();
        } else {
            model.addAttribute("runs", runsForResult);
            return "results";
        }
    }

    @RequestMapping(value = "/results/{runId}")
    public String resultsView(Model model, @PathVariable("runId") final Long runId) {
        LOG.debug("results list");

        List<Participation> particpiants = participationService.findParticipantsWithResults(runId);
        model.addAttribute("participants", particpiants);

        LocalDate actualDate = LocalDate.now();
        List<Run> runs = registerService.findRunsForResult(actualDate.getYear());
        List<Run> runsForResult = runs.stream().filter(b -> b.isShowResult()).collect(Collectors.toList());
        model.addAttribute("runs", runsForResult);

        return "results";
    }
}
