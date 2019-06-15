package com.chwiss.happyclimber.controller;

import com.chwiss.happyclimber.*;
import com.chwiss.happyclimber.model.*;
import com.chwiss.happyclimber.service.ClimberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Author Carlos Sampaio Peredo
 * Version 1.0, Juni 2019
 */
@Controller
@RequestMapping("/climber")
public class ClimberController {
    //mit request mapping ermöglicht nur relativen Pfad auf die Methoden

    @Autowired
    private ClimberService climberService;

    /**
     *
     * @param climber User welche hinzugefügt werden soll
     * @param model spring framework Model
     * @return Werte werden zu main.html zurückgegeben
     */
    @PostMapping("/add")
    public String climber(@ModelAttribute @Valid Climber climber, Model model) {
        //@ModelAttribute weil es Werte aus ein Formular ist
        climberService.addClimber(climber);
        model.addAttribute("climber");
        return "main";

    }

    @GetMapping
    public String showForm(Model model){
        model.addAttribute("climber", new Climber());
        return "climberForm";
    }





}
