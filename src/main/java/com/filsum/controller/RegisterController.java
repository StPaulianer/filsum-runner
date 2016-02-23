package com.filsum.controller;

import com.filsum.model.Run;
import com.filsum.model.RunnerFormData;
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
import java.util.*;

@Controller
public class RegisterController {

    private static final Logger LOG = LoggerFactory.getLogger(ParticipationController.class.getName());

    private static final LinkedList<String> availShirts = new LinkedList<String>() {{
        add("S");
        add("M");
        add("L");
        add("XL");
    }};

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register")
    public String registerView(Model model) {
        LOG.debug("register runner view");
        model.addAttribute("runnerData", new RunnerFormData());

        List<Run> runs = registerService.findRunsToRegister();
        model.addAttribute("runs", runs);

        model.addAttribute("availShirts", availShirts);
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

            model.addAttribute("runnerData", new RunnerFormData());
            model.addAttribute("availShirts", availShirts);
            return "register/register";
        }

        registerService.createParticipation(runnerData);
        return "register/registerSuccess";
    }

    protected void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }
}
