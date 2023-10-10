package com.poliszak.marek.my_library.service;

import com.poliszak.marek.my_library.domain.Publisher;
import com.poliszak.marek.my_library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private  final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    //Add new publisher
    public Publisher add(Publisher publisher) {
        if(publisherRepository.existsByName(publisher.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Publisher already exists");
        }
        return this.publisherRepository.save(publisher);
    }

    //Find and return a publisher by its ID
    public Publisher findById(long id) {
        Optional<Publisher> publisherToFindOptional = publisherRepository.findById(id);
        if(publisherToFindOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher doesn't exist.");
        }
        return publisherToFindOptional.get();
    }

    //Find and return ALL publishers
    public Iterable<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    //Delete publisher by its IDs
    public List<Publisher> deleteById(long[] publishersIds) {
        List<Publisher> deletedPublisher = new ArrayList<>();
        for (long publisherId: publishersIds) {
            Optional<Publisher> publisherToDeleteOptional = publisherRepository.findById(publisherId);
            if(publisherToDeleteOptional.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher doesn't exist.");
            }
            Publisher publisherToDelete= publisherToDeleteOptional.get();
            deletedPublisher.add(publisherToDelete);
            this.publisherRepository.delete(publisherToDelete);
        }
        return deletedPublisher;
    }

    public Publisher updatePublisher(Publisher publisher) {
        Optional<Publisher> publisherToUpdateOptional = publisherRepository.findById(publisher.getId());
        if(publisherToUpdateOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Publisher doesn't exist.");
        }
        return publisherRepository.save(publisher);
    }
}
