package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    private final ArrayList<Publisher> publishers;

    public PublisherController() {
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("Penguin Books Limited", "Westminster"));
        this.publishers.add(new Publisher("Tor Publishing Group", "New York"));
    }

    @GetMapping
    public ArrayList<Publisher> getAll() {
        return this.publishers;
    }

    @GetMapping("/{id}")
    public Publisher getOne(@PathVariable(name = "id") int id) {
        if (id < this.publishers.size()) {
            return this.publishers.get(id);
        }
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable (name = "id") int id, @RequestBody Publisher publisher) {
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return this.publishers.get(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable (name = "id") int id) {
        if (id < this.publishers.size()) {
            return this.publishers.remove(id);
        }
        return null;
    }
}
