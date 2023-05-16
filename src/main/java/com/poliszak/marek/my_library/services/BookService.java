package com.poliszak.marek.my_library.services;

import com.poliszak.marek.my_library.domain.Book;
import com.poliszak.marek.my_library.repositories.AuthorRepository;
import com.poliszak.marek.my_library.repositories.BookRepository;
import com.poliszak.marek.my_library.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;



    //Add new book to the library
    public Book addBooks(Book book) {
        if(bookRepository.existsById(book.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Event already exists");
        }
        return this.bookRepository.save(book);
    }

    //Find and return a book by its ID
    public Book findById(Long id) {
        Optional<Book> bookToFindOptional = bookRepository.findById(id);
        if(bookToFindOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not in the Library.");
        }
        return bookToFindOptional.get();
    }

    //Find and return ALL books from the library
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    //Delete books from library by its IDs
    public List<Book> deleteById(long[] booksIds) {
        List<Book> deletedBooks = new ArrayList<>();
        for (Long bookId: booksIds) {
            Optional<Book> eventToDeleteOptional = bookRepository.findById(bookId);
            if(eventToDeleteOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not in the Library.");
            }
            Book bookToDelete = eventToDeleteOptional.get();
            deletedBooks.add(bookToDelete);
            this.bookRepository.delete(bookToDelete);
        }
        return deletedBooks;
    }

    public Book updateBook(Book book) {
        Optional<Book> bookToUpdateOptional = bookRepository.findById(book.getId());
        if(bookToUpdateOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not in the Library.");
        }
        return bookRepository.save(book);
    }

}
