package com.example.championship.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "position_championship")
@Entity
@Data
public class PositionChampionship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_team")
    private List<Team> teams = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_championship")
    private List<Championship> championships = new ArrayList<>();

    @Column(name = "points")
    private Integer points;

}
