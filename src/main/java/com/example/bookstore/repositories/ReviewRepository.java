package com.example.bookstore.repositories;

import com.example.bookstore.data.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
