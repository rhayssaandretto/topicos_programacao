package com.example.championship.domain;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "team")
@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
