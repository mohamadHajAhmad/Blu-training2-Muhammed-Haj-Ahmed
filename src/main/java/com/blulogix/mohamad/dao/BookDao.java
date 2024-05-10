package com.blulogix.mohamad.dao;


import com.blulogix.mohamad.entity.Book;
import com.blulogix.mohamad.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public String delete(int id) {
        Optional<Book> book = this.bookRepo.findById(id);
        if(book.isPresent()) {
            this.bookRepo.delete(book.get());
            return "Book is deleted";
        }
        else {
            return "book is not exist !";
        }

    }
    public Book update(Book book) {
        return this.bookRepo.save(book);
    }
    public List<Book> getByTitle(String title) {
        List<Book> books = this.bookRepo.findAll();
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if(book.getTitle().equals(title)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
    public List<Book> getByAuthor(String author) {
        List<Book> books = this.bookRepo.findAll();
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if(book.getAother().equals(author))
                filteredBooks.add(book);
        }
        return filteredBooks;
    }
    public List<Book> getByBoth(String author, String title) {
        List<Book> books = this.bookRepo.findAll();
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if(book.getAother().equals(author) && book.getTitle().equals(title)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

}
