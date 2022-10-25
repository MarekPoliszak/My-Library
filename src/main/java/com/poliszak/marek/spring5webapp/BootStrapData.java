package com.poliszak.marek.spring5webapp;

import com.poliszak.marek.spring5webapp.domain.Author;
import com.poliszak.marek.spring5webapp.domain.Book;
import com.poliszak.marek.spring5webapp.domain.Publisher;
import com.poliszak.marek.spring5webapp.repositories.AuthorRepository;
import com.poliszak.marek.spring5webapp.repositories.BookRepository;
import com.poliszak.marek.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher supernowa = new Publisher();
        supernowa.setName("SuperNowa");
        supernowa.setRegon("221548215");

        Publisher albatros = new Publisher("Albatros", "147194817");

        publisherRepository.save(supernowa);
        publisherRepository.save(albatros);

        Author king = new Author("Stephen", "King");
        Book insomnia = new Book("Insomnia", "121342");
        king.getBooks().add(insomnia);
        insomnia.getAuthors().add(king);
        insomnia.setPublisher(albatros);
        albatros.getBooks().add(insomnia);

        authorRepository.save(king);
        bookRepository.save(insomnia);
        publisherRepository.save(albatros);


        Author sap = new Author("Andrzej", "Sapkowski");
        Book witcher = new Book("Witcher", "976556");
        sap.getBooks().add(witcher);
        witcher.getAuthors().add(sap);
        witcher.setPublisher(supernowa);
        supernowa.getBooks().add(witcher);

        authorRepository.save(sap);
        bookRepository.save(witcher);
        publisherRepository.save(supernowa);

        System.out.println("Started in Bootstrap");
        /*System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println(albatros.getBooks().size());
        System.out.println(supernowa.getBooks().size());
        System.out.println("Number of books: " + bookRepository.count()); */
    }
}
