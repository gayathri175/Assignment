package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Freshman {
    private String name;

    @Autowired
    @Qualifier("dormRoom2")  // Use this for second option
    private DormRoom room;

    public Freshman() {
        this.name = "John Smith";
    }

    public String getName() {
        return name;
    }

    public DormRoom getRoom() {
        return room;
    }

    public void printDetails() {
        System.out.println("Name: " + getName());
        System.out.println("DormRoom: " + getRoom());
    }
}

