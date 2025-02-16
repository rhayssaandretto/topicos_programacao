package com.example.championship.services;

import com.example.championship.domain.Championship;
import com.example.championship.repositories.ChampionshipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChampionshipService {

    private final ChampionshipRepository repository;

    public List<Championship> findAll() {

        return repository.findAll();
    }

    public void create(Championship championship) {

        repository.save(championship);
    }

}
