package com.poliszak.marek.spring5webapp.repositories;

import com.poliszak.marek.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
