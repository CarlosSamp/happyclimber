package com.chwiss.happyclimber.repository;

import com.chwiss.happyclimber.model.Ascent;
import com.chwiss.happyclimber.model.Climber;
import com.chwiss.happyclimber.model.JournalPosition;
import com.chwiss.happyclimber.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface JournalPosRepository extends JpaRepository<JournalPosition, Long>, CrudRepository<JournalPosition, Long> {
    Optional<JournalPosition> findById(Long id);
    //Optional<JournalPosition> getAllById();
    //Integer countByClimberId();

}
