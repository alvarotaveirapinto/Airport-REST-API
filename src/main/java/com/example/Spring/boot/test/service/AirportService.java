package com.example.Spring.boot.test.service;

import com.example.Spring.boot.test.exception.AirportIdException;
import com.example.Spring.boot.test.exception.UpdateAirportException;
import com.example.Spring.boot.test.model.Airport;
import com.example.Spring.boot.test.repository.AirportRepository;
import com.example.Spring.boot.test.request.NewAirportRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Airport airportById(Long id) throws AirportIdException {
        Airport airport = airportRepository.findById(id).orElseThrow(
                () -> new AirportIdException("AIRPORT WITH" + id + "NOT FOUND"));
        return airport;
    }

    public List<Airport> airportList() {
        return airportRepository.findAll();
    }

    public Airport addAirport(NewAirportRequest airport) {
        Airport newAirport = Airport.builder().name(airport.getName()).build();
        airportRepository.save(newAirport);
        return newAirport;
    }


    public void deleteAirport(Long airportId) {
        airportRepository.deleteById(airportId);
        }

    public Airport updateAirport(Long id, String name) throws UpdateAirportException {
        Airport airport = airportRepository.findById(id).orElseThrow(
                () -> new UpdateAirportException("Airport" + name + "Updated"));
        return airport;
    }
}


