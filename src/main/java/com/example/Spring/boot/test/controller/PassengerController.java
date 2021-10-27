package com.example.Spring.boot.test.controller;

import com.example.Spring.boot.test.exception.PassengerIdNotFoundException;
import com.example.Spring.boot.test.exception.PassengerNameNotFound;
import com.example.Spring.boot.test.model.Passenger;
import com.example.Spring.boot.test.request.PassengerIdRequest;
import com.example.Spring.boot.test.service.PassengerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@ControllerAdvice
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping(value = "/get-all/passenger")
    @ApiOperation(value = "Getting all the passenger")
    public List<Passenger> passengerList(){
        return passengerService.passengerList();
    }
    @GetMapping(value = "get-passenger/id/{id}")
    @ApiOperation(value = "Getting passenger by id")
    public Passenger passengerById(@PathVariable("id") Long id) throws PassengerIdNotFoundException {
        return passengerService.passengerById(id);
    }
    @ExceptionHandler(value = PassengerIdNotFoundException.class)
    public ResponseEntity<String> PassengerIdNotFound(PassengerIdNotFoundException exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/post-add/passenger")
    @ApiOperation(value = "Adding a passenger")
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @PutMapping(value = "/put-edit/passenger/name/{id}")
    @ApiOperation(value = "Edit a passenger by id")
    public ResponseEntity editPassengerById(@PathVariable Long id, @RequestBody PassengerIdRequest request) throws PassengerNameNotFound {
        final Passenger passenger = passengerService.editPassengerById( id, request.getName());
        return ResponseEntity.created(URI.create("passenger" + id + "name")).body("Updated name");
    }
    @ExceptionHandler(value = PassengerNameNotFound.class)
    public ResponseEntity<String> passengerNotFound(PassengerNameNotFound exception) {
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}

