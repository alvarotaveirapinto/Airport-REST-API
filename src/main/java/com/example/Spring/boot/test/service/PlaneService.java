package com.example.Spring.boot.test.service;

import com.example.Spring.boot.test.model.Plane;
import com.example.Spring.boot.test.repository.PlaneRepository;
import com.example.Spring.boot.test.request.PlaneRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {
    @Autowired
    private PlaneRepository planeRepository;

    public Plane addPlane(PlaneRequest planeRequest) {
        Plane newPlane = Plane.builder().name(planeRequest.getName()).build();
        return planeRepository.save(newPlane);
    }

    public void deletePlane(Long id) {
         planeRepository.deleteById(id);
    }
}
