package com.example.bookstore.controller;

import com.example.bookstore.data.Book;
import com.example.bookstore.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

  private final BookRepository bookRepository;

  @PostMapping
  @CacheEvict(value = "books", allEntries = true)
  public ResponseEntity<Book> addBook(@RequestBody Book book) {
    Book savedBook = bookRepository.save(book);
    return ResponseEntity.ok(savedBook);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBook(@PathVariable Long id) {
    Optional<Book> book = bookRepository.findById(id);
    return book.map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
}
