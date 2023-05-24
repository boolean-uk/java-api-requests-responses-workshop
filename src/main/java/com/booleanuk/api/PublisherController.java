package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private static int CURRENT_ID = 0;
    private Map<Integer, Publisher> publishers;

    public PublisherController(){
        publishers = new HashMap<>();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher){
        publisher.setId(CURRENT_ID++);
        publishers.put(publisher.getId(), publisher);
        return publishers.get(publisher.getId());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAll(){
        return publishers.values().stream().toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher get(@PathVariable(name = "id") int id){
        return publishers.get(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable(name = "id") int id, @RequestBody Publisher publisher){
        if(!publishers.containsKey(id)) return null;
        publishers.replace(id, publisher);
        return publishers.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher delete(@PathVariable(name = "id") int id){
        return publishers.remove(id);
    }
}
