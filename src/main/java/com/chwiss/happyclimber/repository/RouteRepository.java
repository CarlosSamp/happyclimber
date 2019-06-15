package com.chwiss.happyclimber.repository;

import com.chwiss.happyclimber.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RouteRepository extends JpaRepository<Route, Integer>, CrudRepository<Route, Integer> {

}
