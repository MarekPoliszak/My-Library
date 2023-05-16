package com.poliszak.marek.my_library.repositories;

import com.poliszak.marek.my_library.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
