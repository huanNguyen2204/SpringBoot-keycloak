package com.example.bookstore.repositories;

import com.example.bookstore.data.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> { }
