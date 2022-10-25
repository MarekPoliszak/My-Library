package com.poliszak.marek.spring5webapp.repositories;

import com.poliszak.marek.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
