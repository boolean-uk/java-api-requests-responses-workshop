package com.booleanuk.api;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublisherRepository {

    private Map<Integer, Publisher> publishers;

    public PublisherRepository(){
        this.publishers = new HashMap<>();
        Publisher firstPublisher = new Publisher("Chanson", "Atlanta");
        Publisher secondPublisher = new Publisher("Bristol", "London");

        publishers.put(firstPublisher.getId(), firstPublisher);
        publishers.put(secondPublisher.getId(), secondPublisher);
    }

    public List<Publisher> getAll(){
        return publishers.values().stream().toList();
    }

    public Publisher getOne(int id){
        return publishers.get(id);
    }

    public Publisher update(int id, Publisher newPublisher){
        Publisher old = publishers.get(id);
        if(old == null) return null;

        old.setName(newPublisher.getName());
        old.setCity(newPublisher.getCity());
        publishers.replace(id, old);
        return publishers.get(id);
    }

    public Publisher create(Publisher publisher){
        Publisher instance = new Publisher(publisher);
        publishers.put(instance.getId(), instance);
        return publishers.get(instance.getId());
    }

    public Publisher delete(int id){
        return publishers.remove(id);
    }
}
