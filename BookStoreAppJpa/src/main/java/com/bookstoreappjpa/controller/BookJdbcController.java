package com.bookstoreappjpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoreappjpa.entity.Book;
import com.bookstoreappjpa.repo.BookNamedDao;
import com.bookstoreappjpa.repo.BookStoreAppJdbcDao;

@RestController
@RequestMapping("/api/jdbc/books")
public class BookJdbcController {
	private final BookStoreAppJdbcDao dao;
    private final BookNamedDao namedDao;

    public BookJdbcController(BookStoreAppJdbcDao dao, BookNamedDao namedDao) {
        this.dao = dao;
        this.namedDao = namedDao;
    }

    @GetMapping
    public List<Book> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public String add(@RequestBody Book book) {
        dao.save(book);
        return "Book added successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        dao.update(book);
        return "Book updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "Book deleted";
    }

    @GetMapping("/author/{author}")
    public List<Book> byAuthor(@PathVariable String author) {
        return namedDao.findByAuthor(author);
    }

    @GetMapping("/price-range")
    public List<Book> byPriceRange(@RequestParam double min, @RequestParam double max) {
        return namedDao.findByPriceRange(min, max);
    }
}
