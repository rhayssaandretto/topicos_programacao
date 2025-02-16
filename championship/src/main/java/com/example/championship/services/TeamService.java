package com.example.championship.services;

import com.example.championship.domain.Team;
import com.example.championship.repositories.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamRepository repository;

    public List<Team> findAll() {

        return repository.findAll();
    }

    public void create(Team team) {

        repository.save(team);
    }
}
