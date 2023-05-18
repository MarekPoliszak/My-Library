package com.poliszak.marek.my_library.repositories;

import com.poliszak.marek.my_library.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    boolean existsByName(String name);
}
