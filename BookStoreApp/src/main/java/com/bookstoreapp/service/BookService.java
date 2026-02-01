package com.bookstoreapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookstoreapp.dto.BookDto;
import com.bookstoreapp.entity.Book;
import com.bookstoreapp.repo.BookRepository;

@Service
public class BookService {
	 private final BookRepository repo;

	    public BookService(BookRepository repo) {
	        this.repo = repo;
	    }

	    public Book addBook(BookDto dto) { 
	    	Book book = new Book(null, dto.getTitle(), dto.getAuthor(), dto.getPrice());
	        return repo.save(book);
	    }
	    public Book updateBook(Integer id, BookDto dto) { 
	    	Book bookToBeUpdated = repo.findById(id);
	        if (bookToBeUpdated == null) {
	            throw new RuntimeException("Book not found");
	        }
	        bookToBeUpdated.setTitle(dto.getTitle());
	        bookToBeUpdated.setAuthor(dto.getAuthor());
	        bookToBeUpdated.setPrice(dto.getPrice());
	        return repo.save(bookToBeUpdated);
	    }
	    public Book getBook(Integer id) { 
	    	Book book = repo.findById(id);
	        if (book == null) {
	            throw new RuntimeException("Book not found");
	        }
	        return book;
	    }
	    public List<Book> getAllBooks() { 
	    	return repo.findAll();
	    }
	    
	    public void deleteBook(Integer id) {
	    	repo.deleteById(id);
	    	System.out.println("Book deleted");
	    }
}
