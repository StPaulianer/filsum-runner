package com.filsum.controller;

import com.filsum.model.Participation;
import com.filsum.model.ParticipationPaidFormData;
import com.filsum.model.Runner;
import com.filsum.model.RunnerFormData;
import com.filsum.service.ParticipationService;
import com.filsum.service.RegisterService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Path;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class.getName());

    @Autowired
    private ParticipationService participationService;

    @Autowired
    private ResultService resultService;

    @Autowired
    private RegisterService registerService;

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
        List<Participation> participants = participationService.findActualRegistered(actualDate.getYear());
        //List<Participation> participants = participationService.findParticipantsByRun(102L);
        model.addAttribute("resultFormData", new ParticipationPaidFormData(participants));

        return "admin/resultlist";
    }

    @RequestMapping(value = "/admin/result", method = RequestMethod.POST)
    public String postResult(Model model, @ModelAttribute("resultFormData") ParticipationPaidFormData participantsFormData) {
        LOG.debug("save results: ", participantsFormData.getParticipants().size());

        resultService.saveResult(participantsFormData.getParticipants());

        LocalDate actualDate = LocalDate.now();
        List<Participation> participants = participationService.findActualRegistered(actualDate.getYear());
        //List<Participation> participants = participationService.findParticipantsByRun(102L);
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



    @RequestMapping(value = "/admin/import", method = RequestMethod.POST)
    public String singleFileUpload(Model model, @RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a file to upload");
            return "admin/import";
        }

        StringBuilder problems = new StringBuilder();
        String line = "";
        String cvsSplitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));// read the first line from the text file

            // headline
            br.readLine();
            while ((line = br.readLine()) != null) {

                try {
                // use comma as separator
                String[] tempParticipation = line.split(cvsSplitBy);

                // Startnr.;Nachname;Vorname;Jahrgang;Geschlecht;Wettbewerb;Verein;ZTF1;ZTF2;ZTF3;Mail;Zeit
                // 402;Ölscher;Heinz;1954;m;5 km;Filsum;678;901;XL;heinz.oelscher@gmx.de;00:00:56

                // try to find participation
                String partId = tempParticipation[7];
                boolean participationExist = false;
                if(partId != null && !partId.isEmpty()) {
                    try {
                        Long participationId = Long.parseLong(partId);
                        participationExist = resultService.saveResult(participationId, tempParticipation[11], tempParticipation[0]);


                    } catch (NumberFormatException ex){
                        problems.append("problem with line "  + line + "/n");
                        problems.append("exception: "  + ex.getMessage() + "/n");
                    }

                }

                // create participation
                if(!participationExist) {

                    createNewParticipation(tempParticipation);
                }

                } catch (Exception ex) {
                    problems.append("problem with line "  + line + "/n");
                    problems.append("exception: "  + ex.getMessage() + "/n");
                }

            }

        } catch (IOException io) {
            problems.append("problem with file "  + file.getName() + "/n");
            problems.append("exception: "  + io.getMessage() + "/n");
        }

        model.addAttribute("success", true);
        if(!problems.toString().isEmpty()){
            model.addAttribute("problems", problems.toString());
        }
        return "admin/import";
    }

    private void createNewParticipation(String[] tempParticipation) throws Exception {
        Long runId = Long.parseLong(tempParticipation[8]);

        Runner newRunner = new Runner();
        newRunner.setSurname(tempParticipation[1]);
        newRunner.setForename(tempParticipation[2]);
        newRunner.setBirthyear(Integer.parseInt(tempParticipation[3]));
        newRunner.setGender(tempParticipation[4]);

        if(tempParticipation[6] != null ){
            newRunner.setClub(tempParticipation[6]);
        }

        if(tempParticipation[9] != null ){
            newRunner.setShirt(tempParticipation[9]);
        }

        if(tempParticipation[10] != null ){
            newRunner.setEmail(tempParticipation[10]);
        }

        Participation newParticipation = new Participation();
        newParticipation.setStartnumber(tempParticipation[0]);
        newParticipation.setRuntime(tempParticipation[11]);
        newParticipation.setPaid(true);

        registerService.createParticipation(newRunner, runId, newParticipation);
    }

    @RequestMapping(value = "/admin/import", method = RequestMethod.GET)
    public String fileUploadPage() {
        return "admin/import";
    }


}