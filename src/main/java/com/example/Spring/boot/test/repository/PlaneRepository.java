package com.example.Spring.boot.test.repository;

import com.example.Spring.boot.test.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
