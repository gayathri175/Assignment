package com.example.uber_ride_producer;

public class Ride {
    private Long id;
    private String operation;
    private String pickupLocation;
    private String dropoffLocation;
    private String driverName;
    private String passengerName;

    public Ride() {}

    public Ride(Long id, String operation, String pickupLocation, String dropoffLocation, String driverName, String passengerName) {
        this.id = id;
        this.operation = operation;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.driverName = driverName;
        this.passengerName = passengerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
}
