package com.lab.librarian.models.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PRECONDITION_FAILED)
public class AllBooksAreTaken extends RuntimeException{

    public AllBooksAreTaken(Long id) {
        super(String.format("All examples of book with id: %d are taken",id));
    }
}
