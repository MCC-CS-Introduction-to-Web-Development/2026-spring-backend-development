package edu.mcc.codeschool.class5;

public class Car extends Vehicle implements SteeringBehavior {

    private boolean fourWheelDrive;

    private boolean thridRow;

    private boolean trunkEngine;

    private boolean fourDoors;

    private boolean luxury;

    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public Car setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
        return this;
    }

    public boolean isThridRow() {
        return thridRow;
    }

    public Car setThridRow(boolean thridRow) {
        this.thridRow = thridRow;
        return this;
    }

    public boolean isTrunkEngine() {
        return trunkEngine;
    }

    public Car setTrunkEngine(boolean trunkEngine) {
        this.trunkEngine = trunkEngine;
        return this;
    }

    public boolean isFourDoors() {
        return fourDoors;
    }

    public Car setFourDoors(boolean fourDoors) {
        this.fourDoors = fourDoors;
        return this;
    }

    public boolean isLuxury() {
        return luxury;
    }

    public Car setLuxury(boolean luxury) {
        this.luxury = luxury;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fourWheelDrive=" + fourWheelDrive +
                ", thridRow=" + thridRow +
                ", trunkEngine=" + trunkEngine +
                ", fourDoors=" + fourDoors +
                ", luxury=" + luxury +
                '}';
    }

    @Override
    public String turnLeft(int degrees) {
        return "Turn on left turn signal; Turn wheel left and drive until at " + degrees + " degrees.";
    }

    @Override
    public String turnRight(int degrees) {
        return "Turn on right turn signal; Turn wheel right and drive until at " + degrees + " degrees.";
    }
}
