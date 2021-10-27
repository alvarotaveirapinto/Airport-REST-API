package com.example.Spring.boot.test.controller;

import com.example.Spring.boot.test.exception.AirportIdException;
import com.example.Spring.boot.test.exception.UpdateAirportException;
import com.example.Spring.boot.test.model.Airport;
import com.example.Spring.boot.test.request.NewAirportRequest;
import com.example.Spring.boot.test.request.UpdateAirportRequest;
import com.example.Spring.boot.test.service.AirportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@ControllerAdvice
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping(value = "/get-user/{id}")
    @ApiOperation(value = "Getting airport by Id")
    public Airport airportById(@PathVariable("id") Long id) throws AirportIdException {
        return airportService.airportById(id);
    }
    @ExceptionHandler(value = AirportIdException.class)
    public ResponseEntity<String> airportNotFound(AirportIdException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/get-all")
    @ApiOperation(value = "Getting all the airports")
    public List<Airport> airportList() {
        return airportService.airportList();
    }

    @PostMapping(value = "/post-add/airport")
    @ApiOperation(value = "Adding an airport")
    public Airport addAirport(@RequestBody NewAirportRequest newAirportRequest) {
        return airportService.addAirport(newAirportRequest);
    }
    @DeleteMapping(value = "/delete/{id}")
    public void deleteAirport(@PathVariable("id") Long airportId) {
        airportService.deleteAirport(airportId);
    }

    @PutMapping(value = "/post-update/airport/{id}/name")
    public ResponseEntity updateAirport(@PathVariable Long id, @RequestBody UpdateAirportRequest request) throws UpdateAirportException {
        final Airport updateAirport = airportService.updateAirport(id, request.getName());
        return ResponseEntity.created(URI.create("/airport/" + id + "/name")).body("Updated Name");
    }
    @ExceptionHandler(UpdateAirportException.class)
    public ResponseEntity<String> updateAirport(UpdateAirportException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.ACCEPTED);
    }

}
