package com.example.championship.controllers;

import com.example.championship.domain.PositionChampionship;
import com.example.championship.services.PositionChampionshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/positions-championship")
public class PositionChampionshipController {

    private final PositionChampionshipService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<PositionChampionship>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> findAll(@RequestBody PositionChampionship positionChampionship) {

        service.create(positionChampionship);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
