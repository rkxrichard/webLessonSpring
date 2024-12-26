package com.greatbit.bookstore1.models;

import java.util.ArrayList;
import java.util.List;

public class BooksStorage {
    private static List<Book> books = new ArrayList<Book>();

    public static List<Book> getBooks() {
        return books;
    }
}
