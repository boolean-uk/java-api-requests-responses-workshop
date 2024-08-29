package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("publisher")
public class PublisherController {
	private ArrayList<Publisher> publishers;

	public PublisherController() {
		this.publishers = new ArrayList<>();

		this.publishers.add(new Publisher("Publisher1", "City1"));
		this.publishers.add(new Publisher("Publisher2", "City2"));
	}

	@GetMapping
	public ArrayList<Publisher> getAll() {
		return this.publishers;
	}
	@GetMapping("/{id}")
	public Publisher getOne(@PathVariable(name = "id") int id) {
		if (id < this.publishers.size()) {
			return this.publishers.get(id);
		}
		return null;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Publisher create(@RequestBody Publisher publisher) {
		this.publishers.add(publisher);
		return publisher;
	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Publisher update(@PathVariable (name = "id") int id, @RequestBody Author author) {
		if (id < this.publishers.size()) {
			this.publishers.get(id).setName(author.getName());
			this.publishers.get(id).setCity(author.getEmail());
			return this.publishers.get(id);
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public Publisher delete(@PathVariable (name = "id") int id) {
		if (id < this.publishers.size()) {
			return this.publishers.remove(id);
		}
		return null;
	}
}