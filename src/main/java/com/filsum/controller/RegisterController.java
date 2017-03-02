package com.filsum.controller;

import com.filsum.model.Participation;
import com.filsum.model.Run;
import com.filsum.model.RunnerFormData;
import com.filsum.service.ParticipationService;
import com.filsum.service.RegisterService;
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
import java.util.*;

@Controller
public class RegisterController {

    private static final Logger LOG = LoggerFactory.getLogger(ParticipationController.class.getName());

    private static final List<String> availShirts =
            Arrays.asList("116/128", "134/140","152/164","164/170","S","M","L","XL","XXL");
    private static final Map<String, String> availGenders = new HashMap<String, String>() {{
        put("", "Bitte wählen Sie");
        put("m", "männlich");
        put("w", "weiblich");
    }};

    @Autowired
    private RegisterService registerService;

    @Autowired
    private ParticipationService participationService;

    /**
     * shows the paid participants of runs of the actual year
     */
    @RequestMapping(value = "/registerlist")
    public String participantView(Model model) {
        LOG.debug("register list");
        System.out.println("register list start");

        LocalDate actualDate = LocalDate.now();
        List<Participation> participants = participationService.findActualRegistered(actualDate.getYear());
        model.addAttribute("participants", participants);

        System.out.println("participants list end");
        return "registerlist";
    }

    @RequestMapping(value = "/register")
    public String registerView(Model model) {
        LOG.debug("register runner view");
        model.addAttribute("runnerData", new RunnerFormData());

        List<Run> runs = registerService.findRunsToRegister();
        model.addAttribute("runs", runs);

        model.addAttribute("availShirts", availShirts);
        model.addAttribute("availGenders", availGenders);
        return "register/register";
    }

    @RequestMapping(value = "/register/add", method = RequestMethod.POST)
    public String registerAdd(Model model, @ModelAttribute("runnerData") @Valid RunnerFormData runnerData,
            BindingResult bindingResult) throws Exception {
        LOG.debug("add new runner");

        if (bindingResult.hasErrors()) {
            LOG.error("Binding errors: " + bindingResult.getErrorCount());
            List<Run> runs = registerService.findRunsToRegister();
            model.addAttribute("runs", runs);

            model.addAttribute("runnerData", runnerData);
            model.addAttribute("norun", true);
            model.addAttribute("availShirts", availShirts);
            model.addAttribute("availGenders", availGenders);
            return "register/register";
        }

        registerService.createParticipation(runnerData);
        return "register/registerSuccess";
    }

    protected void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }
}
