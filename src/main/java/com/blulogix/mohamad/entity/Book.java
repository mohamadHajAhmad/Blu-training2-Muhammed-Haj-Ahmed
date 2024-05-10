package com.blulogix.mohamad.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "books")
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id" )
  private Integer id;
  private String title;
  private String aother;
  private String genre;
  @Column(name = "publication_year")
  private LocalDate publicationYear;
  private float price;
}
