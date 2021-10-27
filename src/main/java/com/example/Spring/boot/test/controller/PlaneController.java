package com.example.Spring.boot.test.controller;

import com.example.Spring.boot.test.model.Plane;
import com.example.Spring.boot.test.request.PlaneRequest;
import com.example.Spring.boot.test.service.PlaneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaneController {
    @Autowired
    private PlaneService planeService;

    @PostMapping(value = "/post-add/flight")
    @ApiOperation(value = "Adding a plane")
    public Plane addPlane(PlaneRequest planeRequest) {
        return planeService.addPlane(planeRequest);
    }

    @DeleteMapping(value = "delete-plane/{id}")
    @ApiOperation(value = "Deleting a plane")
    public void deletePlane(@PathVariable("id")Long id) {
         planeService.deletePlane(id);
    }

}
