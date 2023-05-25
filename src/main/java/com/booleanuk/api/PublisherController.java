package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherRepository publisherRepository;
    public PublisherController(){
        publisherRepository = new PublisherRepository();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher){
        return publisherRepository.create(publisher);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAll(){
        return publisherRepository.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher get(@PathVariable(name = "id") int id){
        return publisherRepository.getOne(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable(name = "id") int id, @RequestBody Publisher publisher){
       return publisherRepository.update(id, publisher);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher delete(@PathVariable(name = "id") int id){
        return publisherRepository.delete(id);
    }
}
