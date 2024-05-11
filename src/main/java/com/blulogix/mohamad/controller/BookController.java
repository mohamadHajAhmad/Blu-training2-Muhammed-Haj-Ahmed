package com.blulogix.mohamad.controller;

import com.blulogix.mohamad.dao.BookDao;
import com.blulogix.mohamad.entity.Book;
import com.blulogix.mohamad.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;

    @GetMapping("/books")
    public Iterable<Book> getAll() {
        return bookDao.getAll();
    }

    @PostMapping(path = "/books")
    public Book save(@RequestBody Book book) {
        return bookDao.save(book);
    }

    @GetMapping("/books/{id}")
    public Book getById(@PathVariable int id) {
        return this.bookDao.getById(id);
    }

    @GetMapping("books/delete/{id}")
    public String delete(@PathVariable int id) {
        return bookDao.delete(id);

    }
    @GetMapping("books/search")
    public Iterable<Book> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        if (title != null && author != null) {
            return this.bookDao.getByBoth(title, author);
        } else if (title != null) {
            return this.bookDao.getByTitle(title);
        } else if (author != null) {
            return this.bookDao.getByAuthor(author);
        } else {
            return this.bookDao.getAll();
        }
    }
}
