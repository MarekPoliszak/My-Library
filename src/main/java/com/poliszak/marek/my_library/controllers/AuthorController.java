package com.poliszak.marek.my_library.controllers;

import com.poliszak.marek.my_library.domain.Author;
import com.poliszak.marek.my_library.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

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
