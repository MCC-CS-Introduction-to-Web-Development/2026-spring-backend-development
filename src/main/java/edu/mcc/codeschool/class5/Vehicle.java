package edu.mcc.codeschool.class5;

public class Vehicle {
    private Integer numberOfTires;

    private String color;

    private Boolean isElectric;

    private Integer numberOfPassengers;

    private Integer year;

    private String make;

    private String model;

    private Double miles;

    public String honkHorn(){
        return "honk!";
    }

    public Integer getNumberOfTires() {
        return numberOfTires;
    }

    public Vehicle setNumberOfTires(Integer numberOfTires) {
        this.numberOfTires = numberOfTires;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Vehicle setColor(String color) {
        this.color = color;
        return this;
    }

    public Boolean getElectric() {
        return isElectric;
    }

    public Vehicle setElectric(Boolean electric) {
        isElectric = electric;
        return this;
    }

    public Integer getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public Vehicle setNumberOfPassengers(Integer numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Vehicle setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getMake() {
        return make;
    }

    public Vehicle setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Vehicle setModel(String model) {
        this.model = model;
        return this;
    }

    public Double getMiles() {
        return miles;
    }

    public Vehicle setMiles(Double miles) {
        this.miles = miles;
        return this;
    }
}
