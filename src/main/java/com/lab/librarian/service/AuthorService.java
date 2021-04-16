package com.lab.librarian.service;

import com.lab.librarian.models.Author;
import com.lab.librarian.models.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);

}
