package com.lab.librarian.models.dto;


import com.lab.librarian.models.Country;
import lombok.Data;

import javax.persistence.*;

@Data
public class AuthorDto {

    private String name;

    private String surname;

    private Long country;

    public AuthorDto() {
    }

    public AuthorDto(String name, String surname, Long country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
