package com.lab.librarian.models.dto;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CountryDto {

    private String name;

    private String continet;

    public CountryDto() {
    }

    public CountryDto( String name, String continet) {
        this.name = name;
        this.continet = continet;
    }
}
