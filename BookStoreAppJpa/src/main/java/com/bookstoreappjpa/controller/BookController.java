package com.bookstoreappjpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoreappjpa.entity.Book;
import com.bookstoreappjpa.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book add(@RequestBody Book book) {
        return service.add(book);
    }

    @GetMapping
    public List<Book> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/author/{author}")
    public List<Book> byAuthor(@PathVariable String author) {
        return service.byAuthor(author);
    }

    @GetMapping("/category/{category}")
    public List<Book> byCategory(@PathVariable String category) {
        return service.byCategory(category);
    }

    @GetMapping("/price/less/{price}")
    public List<Book> priceLess(@PathVariable Double price) {
        return service.priceLessThan(price);
    }

    @GetMapping("/search/{keyword}")
    public List<Book> search(@PathVariable String keyword) {
        return service.search(keyword);
    }

    @GetMapping("/price-range")
    public List<Book> priceRange(@RequestParam double min, @RequestParam double max) {
        return service.priceRange(min, max);
    }
}
