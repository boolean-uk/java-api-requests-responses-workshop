package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublishersController {
    private ArrayList<Publisher> publishers;

    public PublishersController() {
        this.publishers = new ArrayList<>();

        this.publishers.add(new Publisher("JRR Tolkien", "Rotterdam"));
        this.publishers.add(new Publisher("Jane Austen", "Aarhus"));
    }

    @GetMapping
    public ArrayList<Publisher> getAll() {
        return this.publishers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getOne(@PathVariable(name = "id") int id) {
        if (id < this.publishers.size()) {
            return ResponseEntity.ok().body(this.publishers.get(id));
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Publisher> create(@RequestBody Publisher publisher) {
        if (publisher.getName() != null && publisher.getCity() != null) {
            this.publishers.add(publisher);
            return ResponseEntity.ok().body(publisher);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Publisher> update(@PathVariable (name = "id") int id, @RequestBody Publisher publisher) {
        if (id < this.publishers.size()) {
            if(publisher.getName() != null && publisher.getCity() != null) {
                this.publishers.get(id).setName(publisher.getName());
                this.publishers.get(id).setCity(publisher.getCity());
                return ResponseEntity.ok().body(this.publishers.get(id));
            }
        }
        return ResponseEntity.badRequest().body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> delete(@PathVariable (name = "id") int id) {
        if (id < this.publishers.size()) {
            return ResponseEntity.ok().body(this.publishers.remove(id));
        }
        return ResponseEntity.badRequest().body(null);
    }
}
