package com.booleanuk.api;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("authors")
public class AuthorsController {
    private ArrayList<Author> authors;

    public AuthorsController() {
        this.authors = new ArrayList<>();
        this.authors.add(new Author("Dennis Voutos", "DV@gmail.com"));
        this.authors.add(new Author("Makis Voutos", "MV@gmail.com"));
    }
    @GetMapping
    public ArrayList<Author> getAll(){
        return this.authors;
    }
    @GetMapping("/{index}")
    public Author getSpecificAuthor(@PathVariable (name = "index") int id){
        if(id <0 || id > this.authors.size()){
            return null;
        }
        return this.authors.get(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author){
        this.authors.add(author);
        return author;
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Author update(@RequestBody Author author, @PathVariable (name = "id") int id){
        if(id<0 || id> this.authors.size()){
            return null;
        }
        this.authors.get(id).setName(author.getName());
        this.authors.get(id).setEmail(author.getEmail());
        return this.authors.get(id);
    }

    @DeleteMapping("/{id}")
    public Author delete(@PathVariable (name = "id") int id){
        if(id<0 || id> this.authors.size()){
            return null;
        }
        return this.authors.remove(id);
    }
}
