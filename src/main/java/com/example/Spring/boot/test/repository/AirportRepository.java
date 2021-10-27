package com.example.Spring.boot.test.repository;

import com.example.Spring.boot.test.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

}
