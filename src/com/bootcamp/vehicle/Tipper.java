package com.bootcamp.vehicle;

public final class Tipper extends Vehicle {
    private int capacityInTons;

    public Tipper() {
    }

    public Tipper(int age, long numberOfMiles, boolean isDiesel) {
        super(age, numberOfMiles, isDiesel);
    }

    public Tipper(int age, long numberOfMiles, boolean isDieasel, int capacityInTons) {
        super(age, numberOfMiles, isDieasel);
        this.capacityInTons = capacityInTons;
    }

    public int getCapacityInTons() {
        return capacityInTons;
    }

    public void setCapacityInTons(int capacityInTons) {
        this.capacityInTons = capacityInTons;
    }
}
