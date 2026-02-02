package com.bookstoreappjpa.repo;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bookstoreappjpa.entity.Book;

@Repository
public class BookNamedDao {
	private final NamedParameterJdbcTemplate named;

    public BookNamedDao(NamedParameterJdbcTemplate named) {
        this.named = named;
    }

    public List<Book> findByAuthor(String author) { 
    	 String sql = "SELECT * FROM books_jdbc WHERE author = :author";
         return named.query(sql, Map.of("author", author), new BookRowMapper());
    }

    public List<Book> findByPriceRange(double min, double max) {
    	String sql = "SELECT * FROM books_jdbc WHERE price BETWEEN :min AND :max";
        return named.query(sql, Map.of("min", min, "max", max), new BookRowMapper());
    }
}
