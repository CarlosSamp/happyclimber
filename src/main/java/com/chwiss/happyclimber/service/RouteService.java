package com.chwiss.happyclimber.service;

import com.chwiss.happyclimber.model.Climber;
import com.chwiss.happyclimber.model.Route;
import com.chwiss.happyclimber.repository.ClimberRepository;
import com.chwiss.happyclimber.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * Author Carlos Sampaio Peredo
 * Version 1.0, Juni 2019
 */
@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    /**
     *
     * @param route Route welche hinzugefügt werden soll
     * @return ID von hinzugefügte Route
     */
    public Long addRoute(@Valid Route route){
        routeRepository.saveAndFlush(route);
        return route.getId();
    }

    /**
     *
     * @return Liste alle gespeicherte Routen
     */
    public List<Route> getRoute(){
        return routeRepository.findAll();

    }
}
