package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.util.StringUtils.hasLength;

@RestController
@RequestMapping("/publishers")
public class PublishersController {

    private ArrayList<Publisher> publishers;

    public PublishersController() {
        this.publishers = new ArrayList<>();
        this.publishers.add(new Publisher("Penguin", "New York"));
        this.publishers.add(new Publisher("Bloomsbury", "London"));
    }

    @GetMapping
    public ArrayList<Publisher> getPublishers() {
        return this.publishers;
    }
    @GetMapping("/{id}")
    public Publisher getSpecificPublisher(@PathVariable int id) {
        if (id < this.publishers.size()) {
            return this.publishers.get(id);
        }
        throw new NotFoundException("Publisher not found");

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        if (!hasLength(publisher.getName()) || !hasLength(publisher.getCity())) {
            throw new BadRequestException("Name and City are required.");
        }
        this.publishers.add(publisher);
        return publisher;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable (name = "id") int id, @RequestBody Publisher publisher) {
        if (!hasLength(publisher.getName()) || !hasLength(publisher.getCity())) {
            throw new BadRequestException("Name and City are required.");
        }
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return this.publishers.get(id);
        }else {
            throw new NotFoundException("Publisher not found");
        }

    }
    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable (name = "id") int id) {
        if (id < this.publishers.size()) {
            return this.publishers.remove(id);
        }
        throw new NotFoundException("Publisher not found");
    }
}
