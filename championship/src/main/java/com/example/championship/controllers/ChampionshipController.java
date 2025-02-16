package com.example.championship.controllers;

import com.example.championship.domain.Championship;
import com.example.championship.services.ChampionshipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/championships")
public class ChampionshipController {

    private final ChampionshipService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Championship>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> findAll(@RequestBody Championship championship) {

        service.create(championship);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
