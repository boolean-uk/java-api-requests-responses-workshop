package com.booleanuk.api.controllers;

import com.booleanuk.api.models.Publisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Publisher> getOne(@PathVariable(name = "id") int id) {
        if (id < this.publishers.size()) {
            return ResponseEntity.ok(this.publishers.get(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> update(@PathVariable (name = "id") int id, @RequestBody Publisher publisher) {
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return ResponseEntity.status(HttpStatus.CREATED).body(this.publishers.get(id));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> delete(@PathVariable (name = "id") int id) {
        if (id < this.publishers.size()) {
            return ResponseEntity.ok(this.publishers.remove(id));
        }
        return ResponseEntity.notFound().build();
    }
}
