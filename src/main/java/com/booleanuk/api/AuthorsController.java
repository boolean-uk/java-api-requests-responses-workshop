package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    private final ArrayList<Author> authors;

    public AuthorsController() {
        authors = new ArrayList<>(){
            {
                add(new Author("JRR Tolkien", "jrr@tolkien.com"));
                add(new Author("Jane Austen", "jane@austen.com"));
            }
        };
    }

    @GetMapping
    public ArrayList<Author> getAll() {
        return this.authors;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody Author author) {
        this.authors.add(author);
        return author;
    }

    @GetMapping("/{id}")
    public Author getSpecificAuthor(@PathVariable int id){
        if (id < this.authors.size()){
            return this.authors.get(id);
        }
        return null;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateSpecificAuthor(@PathVariable int id, @RequestBody Author author){
        if (id < this.authors.size()){
            this.authors.get(id).setName(author.getName());
            this.authors.get(id).setEmail(author.getEmail());
            return this.authors.get(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Author deleteAuthor(@PathVariable int id){
        if (id < this.authors.size()){
            return this.authors.remove(id);
        }
        return null;
    }
}
