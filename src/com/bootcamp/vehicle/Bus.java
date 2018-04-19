package com.bootcamp.vehicle;

public final class Bus extends Vehicle {
    private int numberOfSeats;

    public Bus() {
    }

    public Bus(int age, long numberOfMiles, boolean isDiesel) {
        super(age, numberOfMiles, isDiesel);
    }

    public Bus(int age, long numberOfMiles, boolean isDieasel, int numberOfSeats) {
        super(age, numberOfMiles, isDieasel);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
