package com.booleanuk.api;

import java.util.ArrayList;

public class AuthorsController {
    private ArrayList<Author> authors;

    public AuthorsController() {
        this.authors = new ArrayList<>();

        this.authors.add(new Author("JRR Tolkien", "jrr@tolkien.com"));
        this.authors.add(new Author("Jane Austen", "jane@austen.com"));
    }
}