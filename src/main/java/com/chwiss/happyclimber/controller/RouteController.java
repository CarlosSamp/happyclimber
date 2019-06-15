package com.chwiss.happyclimber.controller;

import com.chwiss.happyclimber.model.*;
import com.chwiss.happyclimber.repository.RouteRepository;
import com.chwiss.happyclimber.repository.SectorRepository;
import com.chwiss.happyclimber.service.JournalService;
import com.chwiss.happyclimber.service.RouteService;
import com.chwiss.happyclimber.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Author Carlos Sampaio Peredo
 * Version 1.0, Juni 2019
 */
@Controller
@RequestMapping("/route")
@SessionAttributes("log")
public class RouteController {

    @Autowired
    private RouteService routeService;
    @Autowired
    private SectorService sectorService;

    @Autowired
    private RouteRepository routeRepository;

    @PostMapping("/add")
    public String route(@ModelAttribute Route route, Model model) {

        routeService.addRoute(route);
        model.addAttribute("route", new Route());
        model.addAttribute("grade", Grade.values());
        model.addAttribute("sectorlist", sectorService.getSector());
        return "redirect:/route";

    }/**/
    @PostMapping("/addsector")
    public String sector(@ModelAttribute Sector sector, Model model) {

        sectorService.addSector(sector);
        model.addAttribute("sector", new Sector());
        return "redirect:/route";

    }
    @GetMapping
    public String showForm(Model model){
        model.addAttribute("sectora", new Sector());
        model.addAttribute("route", new Route());
        model.addAttribute("grade", Grade.values());
        model.addAttribute("sector", sectorService.getSector());
        return "routeForm";
    }

}
