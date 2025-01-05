package com.greatbit.bookstore1.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BooksStorage {
    private static List<Book> books = new ArrayList<Book>();

    static {
        books.add(new Book(UUID.randomUUID().toString(), "book1", "author1", 430));
        books.add(new Book(UUID.randomUUID().toString(), "book1", "author1", 320));
    }

    public static List<Book> getBooks() {
        return books;
    }
}
