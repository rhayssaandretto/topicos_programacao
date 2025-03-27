package com.example.atividadeLivro.demo.dto;


import com.example.atividadeLivro.demo.enums.StatusBook;
import com.example.atividadeLivro.demo.model.Book;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long id;

    @NotBlank(message = "Insira um título!")
    private String title;

    @NotBlank(message = "Insira um autor!")
    private String author;

    @NotNull
    @Enumerated(value = EnumType.ORDINAL)
    private StatusBook status;

//    public BookDto (Book book){
//        this.title = book.getTitle();
//        this.author = book.getAuthor();
//        this.status = book.getStatus();
//    }

}