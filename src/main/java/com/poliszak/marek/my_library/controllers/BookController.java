package com.poliszak.marek.my_library.controllers;

import com.poliszak.marek.my_library.domain.Book;
import com.poliszak.marek.my_library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return this.bookService.findAll();
    }

    @PostMapping
    public Book getBookById(@RequestParam long id) {
        return bookService.findById(id);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBooks(book);
    }

    @DeleteMapping("/delete")
    public List<Book> deleteByIds(@RequestParam long[] ids) {
        return bookService.deleteById(ids);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

}
