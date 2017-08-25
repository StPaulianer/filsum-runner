package com.filsum.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class IndexViewController {

    @RequestMapping(path = "/index")
    public String viewIndex() {
        return "index";
    }

    @RequestMapping(path = "/")
    public String viewStart() {
        return "index";
    }

    @RequestMapping(path = "/map")
    public String viewMap() {
        return "map";
    }

    @RequestMapping(path = "/images")
    public String viewImages() {
        return "images";
    }

    @RequestMapping(path = "/impressum")
    public String viewImpressum() {
        return "impressum";
    }

    @RequestMapping(path = "/dataprivacy")
    public String viewIDataprivacy() {
        return "dataprivacy";
    }

    @RequestMapping(path = "/infos")
    public String viewAdvertisment() {
        return "advertisment";
    }

    @RequestMapping(path = "/contact")
    public String viewContact() {
        return "contact";
    }

    @RequestMapping(path = "/sponsor")
    public String viewSponsor() {
        return "sponsor";
    }

    @RequestMapping(path = "/urkunde")
    public String viewUrkunde() {
        return "urkunde";
    }

    @RequestMapping(path = "/teilnehmer")
    public String viewTeilnehmer() {
        return "teilnehmer";
    }
    
    @RequestMapping(path = "/ergebnisse")
    public String viewErgebnisse() {
        return "ergebnisse";
    }

    @RequestMapping(path = "/anmeldung")
    public String viewAnmeldung() {
        return "anmeldung";
    }

    @RequestMapping(path = "/veranstaltungen")
    public String viewVeranstaltungen() {
        return "veranstaltungen";
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
