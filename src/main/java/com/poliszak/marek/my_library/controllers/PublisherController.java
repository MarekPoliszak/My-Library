package com.poliszak.marek.my_library.controllers;

import com.poliszak.marek.my_library.domain.Author;
import com.poliszak.marek.my_library.domain.Publisher;
import com.poliszak.marek.my_library.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public Iterable<Publisher> getAllPublisher() { return this.publisherService.findAll(); }

    @PostMapping
    public Publisher getPublisherById(@RequestParam long id) {
        return publisherService.findById(id);
    }

    @PostMapping("/add")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherService.add(publisher);
    }

    @DeleteMapping("/delete")
    public List<Publisher> deleteByIds(@RequestParam long[] ids) {
        return publisherService.deleteById(ids);
    }

    @PutMapping("/update")
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        return publisherService.updatePublisher(publisher);
    }

}
