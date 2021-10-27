package com.example.Spring.boot.test.repository;

import com.example.Spring.boot.test.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
