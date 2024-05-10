package com.blulogix.mohamad.controller;

import com.blulogix.mohamad.dao.BookDao;
import com.blulogix.mohamad.entity.Book;
import com.blulogix.mohamad.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/get-all")
    public Iterable<Book> getAll() {
        return bookDao.getAll();
    }
    @PostMapping(path = "/save")
    public Book save(@RequestBody Book book) {
        return bookDao.save(book);
    }

    @PostMapping(path = "/save-tses")
    public Book saveTest(@RequestBody Book book) {
        return this.bookDao.save(book);
    }

//    @GetMapping("/search")
//    public Iterable<Book> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
//        if (title != null && author != null) {
//            // Search by both title and author
//            return bookRepo.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(title, author);
//        } else if (title != null) {
//            // Search by title only
//            return bookRepo.findByTitleContainingIgnoreCase(title);
//        } else if (author != null) {
//            // Search by author only
//            return bookRepo.findByAuthorContainingIgnoreCase(author);
//        } else {
//            // If no parameters provided, return all books (or handle differently)
//            return bookRepo.findAll();
//        }
//    }
}
