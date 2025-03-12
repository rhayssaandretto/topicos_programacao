package com.example.atividadeLivro.demo.model;


import com.example.atividadeLivro.demo.enums.StatusBook;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    @Enumerated(value = EnumType.ORDINAL)
    private StatusBook status;

}
