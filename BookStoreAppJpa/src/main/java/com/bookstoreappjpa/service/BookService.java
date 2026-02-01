package com.bookstoreappjpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstoreappjpa.entity.Book;
import com.bookstoreappjpa.repo.BookRepository;

@Service
public class BookService {
	private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book add(Book book) {
        return repo.save(book);
    }

    public Book getById(Integer id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
    
    public List<Book> byAuthor(String author) {
        return repo.findByAuthor(author);
    }

    public List<Book> byCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Book> priceLessThan(Double price) {
        return repo.findByPriceLessThan(price);
    }

    public List<Book> search(String keyword) {
        return repo.searchByTitle(keyword);
    }

    public List<Book> priceRange(double min, double max) {
        return repo.findByPriceRange(min, max);
    }
}
