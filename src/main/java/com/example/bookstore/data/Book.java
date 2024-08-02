package com.example.bookstore.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Generated;

import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {

  @Id
  @Generated
  private Long id;
  private String title;
  private String isbn;

  @ManyToMany
  private List<Author> authors;

  private Boolean published;
}
