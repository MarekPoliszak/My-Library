package com.poliszak.marek.my_library.service;

import com.poliszak.marek.my_library.domain.Book;
import com.poliszak.marek.my_library.repository.AuthorRepository;
import com.poliszak.marek.my_library.repository.BookRepository;
import com.poliszak.marek.my_library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Add new book to the library
    public Book add(Book book) {
        if(bookRepository.existsByTitle(book.getTitle())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Book already in the Library.");
        }
        return this.bookRepository.save(book);
    }

    //Find and return a book by its ID
    public Book findById(long id) {
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
        for (long bookId: booksIds) {
            Optional<Book> bookToDeleteOptional = bookRepository.findById(bookId);
            if(bookToDeleteOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not in the Library.");
            }
            Book bookToDelete = bookToDeleteOptional.get();
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
