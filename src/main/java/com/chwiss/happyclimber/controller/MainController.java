package com.chwiss.happyclimber.controller;


import com.chwiss.happyclimber.model.Climber;
import com.chwiss.happyclimber.model.JournalPosition;
import com.chwiss.happyclimber.service.ClimberService;
import com.chwiss.happyclimber.service.JournalService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


/**
 * Author Carlos Sampaio Peredo
 * Version 1.0, Juni 2019
 */
@Controller
@RequestMapping("/main")
@SessionAttributes("log")
public class MainController {
    //mit request mapping ermöglicht nur relativen Pfad auf die Methoden


    @Autowired
    ClimberService climberService;

    @Autowired
    JournalService journalService;


    /**
     *
     * @param climber welche User sich einloggen will
     * @param session
     * @param model spring framework Model
     * @return Werte werden zu main.html zurückgegeben
     */
    @PostMapping
    public String login(@ModelAttribute Climber climber, HttpSession session, Model model){
        Optional<Climber> optionalClimber = climberService.getByUsername(climber.getUsername());

        if(optionalClimber.isPresent()){
            Climber climber1 = optionalClimber.get();

            if (climber1.getPassword().equals(climber.getPassword())){

                System.out.println("Logged In");

                model.addAttribute("log", climber1);
                session.setAttribute("log", climber1);
                return this.showForm(model, climber1);

            }

        }

        return "main";
    }



    @GetMapping
    public String showForm(Model model, @ModelAttribute Climber climber){
        Optional<Climber> optionalClimber = climberService.getByUsername(climber.getUsername());
        model.addAttribute("climber", new Climber());
        System.out.println("optClimber: "+optionalClimber.isPresent());
        Climber climber1;
        if(optionalClimber.isPresent()){
            climber1 = optionalClimber.get();

        }else{
            climber1 = (Climber) model.asMap().get("log");

        }
        if(climber1 != null) {
            model.addAttribute("journalstats", journalService.getIds());
            model.addAttribute("log", climber1);

            model.addAttribute("countbyclimberid", journalService.countByClimber(climber1));
            model.addAttribute("countonsight", journalService.countOnsight(climber1));
            model.addAttribute("countredpoint", journalService.countRedpoint(climber1));
            model.addAttribute("climber", climber1);

        }
        System.out.println();
        return "main";
    }

    @PostMapping ("/logout")
    public String logout(HttpSession session, SessionStatus status){
        status.setComplete();
        //session.invalidate();

        session.removeAttribute("log");
        System.out.println("Logged out");
        return"redirect:/main";
    }

    @GetMapping(value = "/delete", params ={"id"})
    public String delete (@RequestParam(name ="id")Long id, Model model){
        journalService.deleteJournalPos(id);
        model.addAttribute("journalstats", journalService.getIds());
        return "redirect:/main";
    }




}
