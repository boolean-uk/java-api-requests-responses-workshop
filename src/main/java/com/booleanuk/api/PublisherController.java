package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("publishers")
public class PublisherController {
    private final Map<Integer, Publisher> publishers = new HashMap<>() {{
       put(0, new Publisher("me", "Athens"));
       put(1, new Publisher("myself", "Athens"));
    }};

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Collection<Publisher> getPublishers() {
        return this.publishers.values();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher getPublisher(@PathVariable(name="id") int id) {
        if (!publishers.containsKey(id)) return null;
        return publishers.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher postPublisher(@RequestBody Publisher publisher) {
        int id = this.publishers.keySet().stream().max(Integer::compare).get();
        this.publishers.put(id + 1, publisher);
        return this.publishers.get(id + 1);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher putPublisher(@PathVariable(name="id") int id, @RequestBody Publisher publisher) {
        if (!publishers.containsKey(id)) return null;
        publishers.put(id, publisher);
        return this.publishers.get(id);
    }

    @DeleteMapping("{id}")
    public Publisher deletePublisher(@PathVariable(name="id") int id) {
        if (!publishers.containsKey(id)) return null;
        return publishers.remove(id);
    }
}
