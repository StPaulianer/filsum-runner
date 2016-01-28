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

    @RequestMapping(path = "/contact")
    public String viewContact() {
        return "contact";
    }

    @RequestMapping(path = "/sponsor")
    public String viewSponsor() {
        return "sponsor";
    }


    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        //binder.addValidators(userValidator, emailValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
