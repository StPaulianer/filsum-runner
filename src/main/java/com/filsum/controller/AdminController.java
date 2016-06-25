package com.filsum.controller;

import com.filsum.model.Participation;
import com.filsum.model.ParticipationPaidFormData;
import com.filsum.model.RunnerFormData;
import com.filsum.service.ParticipationService;
import com.filsum.service.ResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class.getName());

    @Autowired
    private ParticipationService participationService;

    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/admin/registerlist", method = RequestMethod.GET)
    public String getRegisterlist(Model model) {
        LOG.debug("register list");

        LocalDate actualDate = LocalDate.now();
        List<Participation> participants = participationService.findActualRegistered(actualDate.getYear());
        model.addAttribute("participantsFormData", new ParticipationPaidFormData(participants));

        return "admin/registerlist";
    }

    @RequestMapping(value = "/admin/resultlist", method = RequestMethod.GET)
    public String getResultlist(Model model) {
        LOG.debug("register list");

        LocalDate actualDate = LocalDate.now();
        //List<Participation> participants = participationService.findActualRegistered(actualDate.getYear());
        List<Participation> participants = participationService.findParticipantsByRun(101L);
        model.addAttribute("resultFormData", new ParticipationPaidFormData(participants));

        return "admin/resultlist";
    }

    @RequestMapping(value = "/admin/result", method = RequestMethod.POST)
    public String postResult(Model model, @ModelAttribute("resultFormData") ParticipationPaidFormData participantsFormData) {
        LOG.debug("save results: ", participantsFormData.getParticipants().size());

        resultService.saveResult(participantsFormData.getParticipants());

        LocalDate actualDate = LocalDate.now();
        //List<Participation> participants = participationService.findActualRegistered(actualDate.getYear());
        List<Participation> participants = participationService.findParticipantsByRun(101L);
        model.addAttribute("resultFormData", new ParticipationPaidFormData(participants));
        model.addAttribute("success", "success");
        return "admin/resultlist";
    }

    @RequestMapping(params = "pay", value = "/admin/change", method = RequestMethod.POST)
    public String postRegisterlist(Model model, @ModelAttribute("participantsFormData") ParticipationPaidFormData participantsFormData,
                                   BindingResult bindingResult) {
        LOG.debug("save pay list: ", participantsFormData.getParticipants().size());

        participationService.savePayStatus(participantsFormData.getParticipants());

        LocalDate actualDate = LocalDate.now();
        List<Participation> participants = participationService.findActualRegistered(actualDate.getYear());
        model.addAttribute("participantsFormData", new ParticipationPaidFormData(participants));
        model.addAttribute("success", "success");
        return "admin/registerlist";
    }

    @RequestMapping(params = "delete", value = "/admin/change", method = RequestMethod.POST)
    public String postDeleteRegistered(Model model, @ModelAttribute("participantsFormData") ParticipationPaidFormData participantsFormData,
                                   BindingResult bindingResult) {
        LOG.debug("delete pay list: ", participantsFormData.getParticipants().size());

        participationService.deleteRegistered(participantsFormData.getParticipants());

        LocalDate actualDate = LocalDate.now();
        List<Participation> participants = participationService.findActualRegistered(actualDate.getYear());
        model.addAttribute("participantsFormData", new ParticipationPaidFormData(participants));
        model.addAttribute("success", "success");
        return "admin/registerlist";
    }

}