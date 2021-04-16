package com.lab.librarian.models.dto;


import com.lab.librarian.models.Author;
import com.lab.librarian.models.enumerations.Category;
import lombok.Data;

import javax.persistence.*;

@Data
public class BookDto {

    private String name;

    private Category category;

    private Long author;

    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, Category category, Long author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
