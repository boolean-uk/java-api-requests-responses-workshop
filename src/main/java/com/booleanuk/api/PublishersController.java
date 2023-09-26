package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/publishers")
public class PublishersController {

    private ArrayList<Publisher> publishers;

    public PublishersController(ArrayList<Publisher> publishers) {
        this.publishers = publishers;

        this.publishers.add(new Publisher("Mike M.", "Akadimias 56"));
        this.publishers.add(new Publisher("George P", "Trikoupi 12"));
    }

    @GetMapping
    public ResponseEntity<ArrayList<Publisher>> getAll() {
        return ResponseEntity.ok(this.publishers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable int id) {
        if (id < this.publishers.size()) {
            return ResponseEntity.ok(this.publishers.get(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Publisher> createPublisher (@RequestBody Publisher publisher) {
        this.publishers.add(publisher);
        return new ResponseEntity<>(publisher, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher) {
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return ResponseEntity.ok(this.publishers.get(id));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Publisher> deletePublisher(@PathVariable int id) {
        if (id < this.publishers.size()) {
            return ResponseEntity.ok(this.publishers.remove(id));
        }
        return ResponseEntity.notFound().build();
    }


}
