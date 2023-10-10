package com.poliszak.marek.my_library.controller;

import com.poliszak.marek.my_library.domain.Author;
import com.poliszak.marek.my_library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public Iterable<Author> getAllAuthors() { return this.authorService.findAll(); }

    @PostMapping
    public Author getAuthorById(@RequestParam long id) {
        return authorService.findById(id);
    }

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.add(author);
    }

    @DeleteMapping("/delete")
    public List<Author> deleteByIds(@RequestParam long[] ids) {
        return authorService.deleteById(ids);
    }

    @PutMapping("/update")
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }

}
