package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("publishers")
public class PublisherController {
    private ArrayList<Publisher> publishers;

    public PublisherController() {
        this.publishers = new ArrayList<>();
        this.publishers.add(new Publisher("Dennis Voutos", "Athens"));
        this.publishers.add(new Publisher("Makis Voutos","Lisbon"));
    }
    @GetMapping
    public ArrayList<Publisher> getAll(){
        return this.publishers;
    }
    @GetMapping("/{index}")
    public Publisher getSpecificPublisher(@PathVariable(name = "index") int id){
        if(id <0 || id > this.publishers.size()){
            return null;
        }
        return this.publishers.get(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher){
        this.publishers.add(publisher);
        return publisher;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@RequestBody Publisher publisher, @PathVariable (name = "id") int id){
        if(id<0 || id> this.publishers.size()){
            return null;
        }
        this.publishers.get(id).setName(publisher.getName());
        this.publishers.get(id).setCity(publisher.getCity());
        return this.publishers.get(id);
    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable (name = "id") int id){
        if(id<0 || id> this.publishers.size()){
            return null;
        }
        return this.publishers.remove(id);
    }
}
