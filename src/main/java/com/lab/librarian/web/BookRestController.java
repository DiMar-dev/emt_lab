package com.lab.librarian.web;

import com.lab.librarian.models.Book;
import com.lab.librarian.models.dto.BookDto;
import com.lab.librarian.models.enumerations.Category;
import com.lab.librarian.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll(){return this.bookService.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto){
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id,@RequestBody BookDto bookDto){
        return this.bookService.edit(id,bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable Long id){
        this.bookService.deleteById(id);

        if (this.bookService.findById(id).isPresent())
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/takeBook/{id}")
    public ResponseEntity<Book> takeABook(@PathVariable Long id){
        return this.bookService.takeBook(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/categories")
    public List<String> getCategories(){
        return Arrays.stream(Category.values()).map(String::valueOf).collect(Collectors.toList());
    }

}
