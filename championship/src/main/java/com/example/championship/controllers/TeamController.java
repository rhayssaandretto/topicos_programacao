package com.example.championship.controllers;

import com.example.championship.domain.Team;
import com.example.championship.services.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Team>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<Void> findAll(@RequestBody Team team) {

        service.create(team);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
