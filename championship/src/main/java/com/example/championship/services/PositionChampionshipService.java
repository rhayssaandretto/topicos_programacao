package com.example.championship.services;

import com.example.championship.domain.PositionChampionship;
import com.example.championship.repositories.PositionChampionshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionChampionshipService {

    private final PositionChampionshipRepository repository;

    public List<PositionChampionship> findAll() {

        return repository.findAll();
    }

    public void create(PositionChampionship positionChampionship) {

        repository.save(positionChampionship);
    }
}
