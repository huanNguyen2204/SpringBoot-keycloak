package com.example.bookstore.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Generated;

@Entity
@Table(name = "authors")
@Data
public class Author {

  @Id
  @Generated
  private Long id;
  private String name;
  private String biography;

  @ManyToOne
  private Publisher publisher;
}
