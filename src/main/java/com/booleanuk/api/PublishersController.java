package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/publishers")
public class PublishersController {
    private final ArrayList<Publisher> publishers;

    public PublishersController() {
        publishers = new ArrayList<>(){
            {
                add(new Publisher("John Brown", "London"));
                add(new Publisher("Alex Georgiou", "Athens"));
            }
        };
    }

    @GetMapping
    public ArrayList<Publisher> getPublishers() {
        return this.publishers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher postPublisher(@RequestBody Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    @GetMapping("/{id}")
    public Publisher getPublisher(@PathVariable int id) {
        if (id < this.publishers.size()) {
            return this.publishers.get(id);
        }
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher putPublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return this.publishers.get(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Publisher deletePublisher(@PathVariable int id) {
        if (id < this.publishers.size()){
            return this.publishers.remove(id);
        }
        return null;
    }
}
