package com.blulogix.mohamad.dao;


import com.blulogix.mohamad.entity.Book;
import com.blulogix.mohamad.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookDao {
    @Autowired
    private BookRepo bookRepo;
    public Iterable<Book> getAll() {
        return this.bookRepo.findAll();
    }
    public Book getById(int id) {
        return this.bookRepo.findById(id).orElse(new Book());
    }
    public Book save(Book book) {
        this.bookRepo.save(book);
        return new Book();
    }
    public Book delete(int id) {
        Book book = this.getById(id);
        this.bookRepo.delete(book);
        return book;
    }
    public Book update(Book book) {
        return this.bookRepo.save(book);
    }

}
