package com.bookstoreapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreAppApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookStoreAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
