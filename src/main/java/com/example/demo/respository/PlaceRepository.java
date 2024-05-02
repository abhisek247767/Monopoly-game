package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
