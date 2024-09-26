package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/publishers")
public class PublisherController {
    private ArrayList<Publisher> publishers;

    public PublisherController(ArrayList<Publisher> publishers) {
        this.publishers = publishers;

        this.publishers.add(new Publisher("Harper Collins", "London"));
        this.publishers.add(new Publisher("AK press", "Seattle"));
    }

    @GetMapping
    public ArrayList<Publisher> getAll() {
        return this.publishers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    @GetMapping("/{id}")
    public Publisher getSpecificPublisher(@PathVariable int id) {
        if (id < this.publishers.size()) {
            return this.publishers.get(id);
        }
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable int id, @RequestBody Publisher publisher) {
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return this.publishers.get(id);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher delete(@PathVariable int id) {
        Publisher publisher = publishers.get(id);
        publishers.remove(id);
        return publisher;
    }
}
