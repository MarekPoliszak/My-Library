package com.poliszak.marek.my_library.repositories;

import com.poliszak.marek.my_library.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    boolean existsByFirstNameAndLastName(String firstName, String lastName);
}
