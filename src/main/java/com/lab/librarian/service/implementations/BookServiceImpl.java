package com.lab.librarian.service.implementations;


import com.lab.librarian.models.Author;
import com.lab.librarian.models.Book;
import com.lab.librarian.models.dto.BookDto;
import com.lab.librarian.models.exceptions.AllBooksAreTaken;
import com.lab.librarian.models.exceptions.AuhtorNotFoundException;
import com.lab.librarian.models.exceptions.BookNotFoundException;
import com.lab.librarian.repository.AuthorRepository;
import com.lab.librarian.repository.BookRepository;
import com.lab.librarian.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author=authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuhtorNotFoundException(bookDto.getAuthor()));

        return Optional.of(this.bookRepository
                                .save(new Book(bookDto.getName(),
                                        bookDto.getCategory(),
                                        author,
                                        bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book=this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        Author author=authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuhtorNotFoundException(bookDto.getAuthor()));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> takeBook(Long id) {
        Book book=this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        if (book.getAvailableCopies() == 0)
            throw new AllBooksAreTaken(id);

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
