package com.example.championship.repositories;

import com.example.championship.domain.PositionChampionship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionChampionshipRepository extends JpaRepository<PositionChampionship, Long> {
}
