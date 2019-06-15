package com.chwiss.happyclimber.service;

import com.chwiss.happyclimber.model.Route;
import com.chwiss.happyclimber.model.Sector;
import com.chwiss.happyclimber.repository.RouteRepository;
import com.chwiss.happyclimber.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Author Carlos Sampaio Peredo
 * Version 1.0, Juni 2019
 */
@Service
public class SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    /**
     *
     * @param sector Sektor welche hinzugefügt werden soll
     * @return ID von hizugefügte Sektor
     */
    public Long addSector(@Valid Sector sector){
        sectorRepository.saveAndFlush(sector);
        return sector.getId();
    }

    /**
     *
     * @param id Welche Sektor soll gefunden werde
     * @return gefundene Sektor
     */
    public Sector getSector(Long id){
        Sector sector = new Sector();
        if(id != null){
            Optional<Sector> optionalSector = sectorRepository.findById(id);
            if(optionalSector.isPresent())
                sector = optionalSector.get();
        }
        return sector;
    }

    /**
     *
     * @return List alle gespeicherte Sektoren
     */
    public List<Sector> getSector(){
        return sectorRepository.findAll();

    }
}
