package com.poliszak.marek.my_library.services;

import com.poliszak.marek.my_library.domain.Author;
import com.poliszak.marek.my_library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    //Add new author
    public Author add(Author author) {
        if(authorRepository.existsById(author.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Author already exists");
        }
        return this.authorRepository.save(author);
    }

    //Find and return an author by its ID
    public Author findById(long id) {
        Optional<Author> authorToFindOptional = authorRepository.findById(id);
        if(authorToFindOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author doesn't exist.");
        }
        return authorToFindOptional.get();
    }

    //Find and return ALL authors
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    //Delete authors by its IDs
    public List<Author> deleteById(long[] authorsIds) {
        List<Author> deletedAuthors = new ArrayList<>();
        for (long authorId: authorsIds) {
            Optional<Author> authorToDeleteOptional = authorRepository.findById(authorId);
            if(authorToDeleteOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author doesn't exist.");
            }
            Author authorToDelete= authorToDeleteOptional.get();
            deletedAuthors.add(authorToDelete);
            this.authorRepository.delete(authorToDelete);
        }
        return deletedAuthors;
    }

    public Author updateAuthor(Author author) {
        Optional<Author> authorToUpdateOptional = authorRepository.findById(author.getId());
        if(authorToUpdateOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author doesn't exist.");
        }
        return authorRepository.save(author);
    }
}
