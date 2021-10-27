package com.example.Spring.boot.test.service;

import com.example.Spring.boot.test.exception.PassengerIdNotFoundException;
import com.example.Spring.boot.test.exception.PassengerNameNotFound;
import com.example.Spring.boot.test.model.Passenger;
import com.example.Spring.boot.test.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> passengerList() {
        return passengerRepository.findAll();
    }

    public Passenger passengerById(Long id) throws PassengerIdNotFoundException {
        return passengerRepository.findById(id).orElseThrow(
                () -> new PassengerIdNotFoundException(" PASSENGER ID NOT FOUND " + id));

    }

    public Passenger addPassenger(Passenger passenger) {
        Passenger passenger1 = passengerRepository.save(passenger);
        return passenger1;
    }

    public Passenger editPassengerById(Long id, String name) throws PassengerNameNotFound {
        Passenger passenger = passengerRepository.findById(id).orElseThrow(
                () -> new PassengerNameNotFound("Passenger name not found" + name));
        return passenger;
    }
}