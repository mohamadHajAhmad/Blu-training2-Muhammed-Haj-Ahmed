package com.blulogix.mohamad.repository;

import com.blulogix.mohamad.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT b FROM Book b WHERE b.title LIKE %:title%")

    List<Book> findByTitle(@Param("title") String title);

    @Query(value = "SELECT b FROM Book b WHERE b.aother LIKE %:aother%")
    List<Book> findByAother(@Param("aother") String aother);

    @Query(value = "SELECT b FROM Book b WHERE b.title LIKE %:title% AND b.aother LIKE %:aother% ")
    List<Book> findByBoth(@Param("title") String title, @Param("aother") String aother);
}
