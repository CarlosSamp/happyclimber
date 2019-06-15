package com.chwiss.happyclimber.repository;

import com.chwiss.happyclimber.model.Climber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClimberRepository extends JpaRepository <Climber, Long>, CrudRepository<Climber, Long> {

    Optional<Climber> findByUsername(String username);
    Optional<Climber> findById(Long id);
}
