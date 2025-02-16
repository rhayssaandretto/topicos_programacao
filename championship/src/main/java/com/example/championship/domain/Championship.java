package com.example.championship.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table( name = "championship")
@Entity
@Data
public class Championship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "initial_date")
    private LocalDateTime initialDate;

    @Column(name = "final_date")
    private LocalDateTime finalDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_championship")
    private List<PositionChampionship> positions = new ArrayList<>();
}
