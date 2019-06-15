package com.chwiss.happyclimber.service;

import com.chwiss.happyclimber.model.*;
import com.chwiss.happyclimber.repository.ClimberRepository;
import com.chwiss.happyclimber.repository.JournalPosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.List;

/**
 * Author Carlos Sampaio Peredo
 * Version 1.0, Juni 2019
 */
@Service
public class JournalService {

    @Autowired
    JdbcTemplate template;
    @Autowired
    private JournalPosRepository journalPosRepository;

    @Autowired
    private ClimberRepository climberRepository;

    /**
     *
     * @param journalPosition journalPosition welche eingefügt werden soll
     * @return gibt die ID zurück welche hinzugefügt wurde
     */
    public Long addJournalPos(JournalPosition journalPosition){
        journalPosRepository.saveAndFlush(journalPosition);
        return journalPosition.getId();
    }

    /**
     *
     * @param id welche id gelöscht werden soll
     */
    public void deleteJournalPos(Long id){
        JournalPosition journalPosition = getJournalPosition(id) ;
        journalPosRepository.delete(journalPosition);
    }

    /**
     *
     * @param id von journalPosition welche gefunden werden soll
     * @return Die journalPosition vom gewünschte id
     */
    public JournalPosition getJournalPosition(Long id){
        JournalPosition journalPosition = new JournalPosition();
        if(id != null){
            Optional<JournalPosition> optionalJournalPosition = journalPosRepository.findById(id);
            if(optionalJournalPosition.isPresent())
                journalPosition = optionalJournalPosition.get();
        }
        return journalPosition;
    }

    /**
     *
     * @return gibt alle ID's zurück vom JournalRepository
     */
    public List<JournalPosition> getIds(){

        return journalPosRepository.findAll();
    }


    /**
     *
     * @param climber gibt an von welcher Kletterer soll gezählt werden
     * @return gibt die Anzahl von insgesamt gekletterte Routen
     */
    public Integer countByClimber (Climber climber){
        Integer total = 0;
        List<JournalPosition> pos = getIds();

        for (JournalPosition poss : pos
             ) {
            if (poss.getClimber().getId() == climber.getId()){
                total ++ ;
            }
        }

        return total;
    }

    public Integer countOnsight (Climber climber){
        Integer total = 0;
        List<JournalPosition> pos = getIds();

        for (JournalPosition poss : pos
        ) {
            if (poss.getClimber().getId() == climber.getId()){
                if(poss.getAscent().equals(Ascent.ON)){
                    total ++ ;
                }
            }
        }

        return total;
    }

    public Integer countRedpoint (Climber climber){
        Integer total = 0;
        List<JournalPosition> pos = getIds();

        for (JournalPosition poss : pos
        ) {
            if (poss.getClimber().getId() == climber.getId()){
                if(poss.getAscent().equals(Ascent.RP)){
                    total ++ ;
                }
            }
        }

        return total;
    }
    /*public Integer countIds() {

        return journalPosRepository.countByClimberId();

    }

    public Optional<JournalPosition> getById(Long id){
        return journalPosRepository.findById(id);
    }*/
}
