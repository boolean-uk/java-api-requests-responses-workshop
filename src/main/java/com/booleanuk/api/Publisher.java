package com.booleanuk.api;

public class Publisher {

    private static int CURRENTID = 1;
    private int id;
    private String name;
    private String city;
    public Publisher(){}

    public Publisher(String name, String city) {
        id = CURRENTID++;
        this.name = name;
        this.city = city;
    }

    public Publisher(Publisher publisher){
        this(publisher.getName(), publisher.getCity());
    }

    public int getId() {
        return id;
    }
    public void setId(int id){this.id=id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
