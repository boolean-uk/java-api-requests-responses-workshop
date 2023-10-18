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

        this.publishers.add(new Publisher("Morten", "Amsterdam"));
        this.publishers.add(new Publisher("Rebeka", "Copenhagen"));
        this.publishers.add(new Publisher("John", "Paris"));
    }

    @GetMapping
    public ArrayList<Publisher> getAll(){
        return this.publishers;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getOne(@PathVariable(name = "id") int id){
        if (id < this.publishers.size()){
            //return this.publishers.get(id);
            return new ResponseEntity<>(this.publishers.get(id),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(null,
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        this.publishers.add(publisher);
        return publisher;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Publisher> update(@PathVariable (name = "id") int id, @RequestBody Publisher publisher){
        if (id < this.publishers.size()) {
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return new ResponseEntity<>(this.publishers.get(id),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable( name = "id") int id) {
        if (id < this.publishers.size()) {
            return this.publishers.remove(id);
        }
        return null;
    }

}
