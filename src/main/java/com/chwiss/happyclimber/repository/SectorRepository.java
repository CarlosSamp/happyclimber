package com.chwiss.happyclimber.repository;

import com.chwiss.happyclimber.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SectorRepository extends JpaRepository<Sector, Long>, CrudRepository<Sector, Long> {

}
