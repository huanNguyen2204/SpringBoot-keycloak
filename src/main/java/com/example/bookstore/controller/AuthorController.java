package com.example.bookstore.controller;

import com.example.bookstore.data.Author;
import com.example.bookstore.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorRepository authorRepository;

  @PostMapping
  public ResponseEntity<Author> addBook(@RequestBody Author author) {
    Author savedAuthor = authorRepository.save(author);
    return ResponseEntity.ok(savedAuthor);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getBook(@PathVariable Long id) {
    Optional<Author> author = authorRepository.findById(id);
    return author.map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping
  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }
}
