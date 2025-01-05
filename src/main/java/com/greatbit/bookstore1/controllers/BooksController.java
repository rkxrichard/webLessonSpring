package com.greatbit.bookstore1.controllers;


import com.greatbit.bookstore1.models.Book;
import com.greatbit.bookstore1.models.BooksStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class BooksController {

    @GetMapping("/")
    public String booksList(Model model) {
        model.addAttribute("books", BooksStorage.getBooks());
        return "books-list";

    }

    @GetMapping("/create-form")
    public String createForm() {
        return "create-form";
    }

    @PostMapping("/create")
    public String createBook(Book book) {
        book.setId(UUID.randomUUID().toString());
        BooksStorage.getBooks().add(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id) {
        Book bookToDelete = BooksStorage.getBooks()
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        BooksStorage.getBooks().remove(bookToDelete);
        return "redirect:/";
    }

    @GetMapping("/edit-form/{id}")
    public String editForm(@PathVariable("id") String id, Model model) {
        Book bookToEdit = BooksStorage.getBooks()
                .stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        model.addAttribute("book", bookToEdit);
        return "edit-form";
    }

    @PostMapping("/update")
    public String editBook(Book book) {
        deleteBook(book.getId());
        BooksStorage.getBooks().add(book);
        return "redirect:/";

    }


}
