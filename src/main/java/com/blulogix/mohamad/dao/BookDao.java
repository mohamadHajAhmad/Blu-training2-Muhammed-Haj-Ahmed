package com.blulogix.mohamad.dao;

import com.blulogix.mohamad.entity.Book;
import com.blulogix.mohamad.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
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
       return this.bookRepo.save(book);
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
      return this.bookRepo.findByTitle(title);
    }
    public List<Book> getByAuthor(String author) {
        return this.bookRepo.findByAother(author);
    }
    public List<Book> getByBoth(String author, String title) {
        return this.bookRepo.findByBoth(author, title);
    }

    public Page<Book> getBooksWithPagination(int pageNo , int pageSize) {
        return this.bookRepo.findAll(PageRequest.of(pageNo , pageSize));
    }

    }

