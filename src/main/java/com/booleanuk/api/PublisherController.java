package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    private ArrayList<Publisher> publishers;

    public PublisherController() {
        this.publishers = new ArrayList<>();
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
    public ResponseEntity<Publisher> delete(@PathVariable (name = "id") int id) {
        if (id < this.publishers.size()) {
            return new ResponseEntity<>(this.publishers.remove(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }
}
