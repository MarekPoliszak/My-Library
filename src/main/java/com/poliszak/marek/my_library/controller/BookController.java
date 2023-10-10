package com.poliszak.marek.my_library.controller;

import com.poliszak.marek.my_library.domain.Book;
import com.poliszak.marek.my_library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> getAllBooks() {
        Iterable<Book> books = bookService.findAll();
        return books;
    }

    @PostMapping
    public Book getBookById(@RequestParam long id) {
        return bookService.findById(id);
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.add(book);
    }

    @DeleteMapping("/delete")
    public List<Book> deleteByIds(@RequestParam long[] id) {
        return bookService.deleteById(id);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

}
