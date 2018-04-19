package com.bootcamp.service;

import com.bootcamp.vehicle.Bus;
import com.bootcamp.vehicle.Car;
import com.bootcamp.vehicle.Tipper;
import com.bootcamp.vehicle.Vehicle;

public final class ConversionUtils {
    private ConversionUtils() {
    }

    static Vehicle getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel) {
        final String carClassName = Car.class.getSimpleName().toUpperCase();
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();

        if (vehicleName.equals(carClassName))
            return new Car(age, numberOfMiles, isDiesel);
        if (vehicleName.equals(busClassName))
            return new Bus(age, numberOfMiles, isDiesel);
        if (vehicleName.equals(tipperClassName))
            return new Tipper(age, numberOfMiles, isDiesel);

        return null;
    }
}
