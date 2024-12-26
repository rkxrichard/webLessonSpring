package com.greatbit.bookstore1;

import com.greatbit.bookstore1.models.Book;
import com.greatbit.bookstore1.models.BooksStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bookstore1Application {

    public static void main(String[] args) {
        BooksStorage.getBooks().add(new Book("Book1", "Author1", 400));
        BooksStorage.getBooks().add(new Book("Book2", "Author2", 400));
        SpringApplication.run(Bookstore1Application.class, args);
    }

}
