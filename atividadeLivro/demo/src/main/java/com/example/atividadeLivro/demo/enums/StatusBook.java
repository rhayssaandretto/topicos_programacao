package com.example.atividadeLivro.demo.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StatusBook {

    DISPONIVEL(0),
    EM_EMPRESTIMO(1),
    RESERVADO(2);

    private  Integer statusBook;

}
