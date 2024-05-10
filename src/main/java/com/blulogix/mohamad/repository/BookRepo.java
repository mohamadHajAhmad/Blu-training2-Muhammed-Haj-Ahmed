package com.blulogix.mohamad.repository;

import com.blulogix.mohamad.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}