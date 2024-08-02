package com.example.bookstore.controller;

import com.example.bookstore.data.Publisher;
import com.example.bookstore.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {

  private final PublisherRepository publisherRepository;

  @PostMapping
  public ResponseEntity<Publisher> addBook(@RequestBody Publisher publisher) {
    Publisher savedPublisher = publisherRepository.save(publisher);
    return ResponseEntity.ok(savedPublisher);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Publisher> getBook(@PathVariable Long id) {
    Optional<Publisher> publisher = publisherRepository.findById(id);
    return publisher.map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping
  public List<Publisher> getAllPublishers() {
    return publisherRepository.findAll();
  }
}
