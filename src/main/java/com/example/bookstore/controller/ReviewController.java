package com.example.bookstore.controller;

import com.example.bookstore.data.Review;
import com.example.bookstore.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

  private final ReviewRepository reviewRepository;

  @PostMapping
  public ResponseEntity<Review> addReview(@RequestBody Review review) {
    Review savedReview = reviewRepository.save(review);
    return ResponseEntity.ok(savedReview);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Review> getReview(@PathVariable String id) {
    Optional<Review> review = reviewRepository.findById(id);
    return review.map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping
  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }
}
