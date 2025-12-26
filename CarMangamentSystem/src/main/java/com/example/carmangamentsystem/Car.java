package com.example.carmangamentsystem;

public class Car {
    String id;
    String model;
    String make;
    int year;

    public Car() {
    }

    public Car(String id, String model, String make, int year) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
