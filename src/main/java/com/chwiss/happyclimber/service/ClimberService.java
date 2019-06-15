package com.chwiss.happyclimber.service;


import com.chwiss.happyclimber.model.*;
import com.chwiss.happyclimber.repository.ClimberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
/**
 * Author Carlos Sampaio Peredo
 * Version 1.0, Juni 2019
 */
@Service
public class ClimberService {

    @Autowired
    private ClimberRepository climberRepository;

    public Long addClimber(@Valid Climber climber){
        climberRepository.saveAndFlush(climber);
        return climber.getId();
    }

    /**
     *
     * @param username User welche gefunden werden soll
     * @return gefundene User zurückgeben
     */
    public Optional<Climber> getByUsername(String username){

        return climberRepository.findByUsername(username);
    }

    /**
     *
     * @param id welche gefunden werden soll
     * @return gefundene ID
     */
    public Optional<Climber> getById(Long id){
        return climberRepository.findById(id);
    }
}
