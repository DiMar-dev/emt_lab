package com.lab.librarian.models.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AuhtorNotFoundException extends RuntimeException{

    public AuhtorNotFoundException(Long id) {
        super(String.format("Author with id: %d was not found",id));
    }
}
