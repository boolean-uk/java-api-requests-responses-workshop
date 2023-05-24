package com.booleanuk.api;

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
        this.publishers.add(new Publisher("John","Thessaloniki"));
        this.publishers.add(new Publisher("Panos","Athens"));
    }
    @GetMapping
    public ArrayList<Publisher> getAll() {
        return this.publishers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getOne(@PathVariable Integer id) {
        if (id < this.publishers.size()) {
            return new ResponseEntity<>(this.publishers.get(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Publisher> update(@PathVariable Integer id, @RequestBody Publisher publishers) {
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(publishers.getName());
            this.publishers.get(id).setCity(publishers.getCity());
            return new ResponseEntity<>(this.publishers.get(id),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> delete(@PathVariable (name = "id") int id) {
        if (id < this.publishers.size()) {
            return new ResponseEntity<>(this.publishers.remove(id),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
}
