package com.poliszak.marek.my_library.controller;

import com.poliszak.marek.my_library.domain.Publisher;
import com.poliszak.marek.my_library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

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
