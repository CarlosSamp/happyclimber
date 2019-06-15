package com.chwiss.happyclimber.controller;

import com.chwiss.happyclimber.model.*;
import com.chwiss.happyclimber.repository.SectorRepository;
import com.chwiss.happyclimber.service.JournalService;
import com.chwiss.happyclimber.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.EnumSet;
import java.util.Optional;

/**
 * Author Carlos Sampaio Peredo
 * Version 1.0, Juni 2019
 */
@Controller
@RequestMapping("/journal")
@SessionAttributes("log")
public class JournalPosController {

    @Autowired
    private JournalService journalService;

    @Autowired
    private RouteService routeService;

    /**
     *
     * @param climber welche User fügt die Positionhinzu, climber id wird in JournalPosition gespeichert und Session wird erstellt
     * @param journalPosition
     * @param model
     * @return
     */
    @PostMapping("/add")
    public String journalPosition(@SessionAttribute("log") Climber climber, @ModelAttribute JournalPosition journalPosition, Model model) {
        //@ModelAttribute weil es Werte aus ein Formular ist
        System.out.println(journalPosition.getAscent());

        //String place = journalPosition.getRoute().getSector().getPlace();
        //sectorRepository.findByPlace(place);
        // Sectorrepository - abfrage ob place existiert
        //journalPosition.getSector().getRoute().getName();
        // sectorrepository - abfrage ob name der route existiert
        // ja vorhanden dann
        //journalPosition.setSector(sectorvonresult);

        journalPosition.setClimber(climber);
        journalService.addJournalPos(journalPosition);
        //model.addAttribute("ascent", EnumSet.allOf(Ascent.class));
        model.addAttribute("ascent", Ascent.values());
        model.addAttribute("grade", Grade.values());
        model.addAttribute("route", routeService.getRoute());
        model.addAttribute("journalPosition", new JournalPosition());

        return "redirect:/main";

    }/**/

    @GetMapping (value = {"", "/{id}"})
    public String showForm(@PathVariable("id") Optional<Long> id, Model model){
        JournalPosition journalPosition;
        if(id.isPresent())
            journalPosition = journalService.getJournalPosition(id.get());
        else
            journalPosition = new JournalPosition();
        model.addAttribute("ascent", Ascent.values());
        model.addAttribute("grade", Grade.values());
        model.addAttribute("route", routeService.getRoute());
        //System.out.println(Ascent.values()[0].getLabel());
        //System.out.println(Grade.values()[0].getLabel());
        model.addAttribute("journalPosition", new JournalPosition());

        return "journalForm";
    }

}
