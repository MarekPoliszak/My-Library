package com.poliszak.marek.spring5webapp.controllers;

import com.poliszak.marek.spring5webapp.domain.Book;
import com.poliszak.marek.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books/list")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "list";
    }

    @PostMapping("/books/add")
    public String addBooks() {

        return "list";
    }
}
