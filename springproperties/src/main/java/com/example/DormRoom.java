package com.example;

public class DormRoom {
    private int number;
    private String building;

    public DormRoom(int number, String building) {
        this.number = number;
        this.building = building;
    }

    public String getLocation() {
        return "Room " + number + " in " + building;
    }

    @Override
    public String toString() {
        return getLocation();
    }
}
