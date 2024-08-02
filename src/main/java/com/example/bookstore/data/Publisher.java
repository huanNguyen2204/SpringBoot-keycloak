package com.example.bookstore.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Generated;

@Entity
@Table(name = "publishers")
@Data
public class Publisher {

  @Id
  @Generated
  private Long id;
  private String name;
  private String address;
}
