package com.lab.librarian.service;

import com.lab.librarian.models.Book;
import com.lab.librarian.models.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> takeBook(Long id);

    void deleteById(Long id);
}
