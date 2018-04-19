package com.bootcamp;

import com.bootcamp.calculator.InsurancePolicyCalculator;
import com.bootcamp.dao.impl.VehicleInfoPlainFileDao;
import com.bootcamp.formula.Formula;
import com.bootcamp.model.VehicleInfo;
import com.bootcamp.vehicle.Bus;
import com.bootcamp.vehicle.Car;
import com.bootcamp.vehicle.Tipper;
import com.bootcamp.vehicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private static List<VehicleInfo> listOfVehicles;
    private static final String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";

    public static void main(String[] args) {

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        if (args.length >= 1) {
            final VehicleInfoPlainFileDao vehicleInfoPlainFileDao = new VehicleInfoPlainFileDao(args[0]);
            listOfVehicles = vehicleInfoPlainFileDao.getAllVehicles();
            for (VehicleInfo vehicleInfoDao : vehicleInfoPlainFileDao.getAllVehicles()) {
                final Vehicle vehicle = getVehicle(vehicleInfoDao);
                final Formula formula = Formula.valueOf(vehicleInfoDao.getVehicleTypeFormula());
                final int totalCost = calculator.calculate(vehicle, formula);
                final String output = String.format(OUTPUT_FORMAT, vehicleInfoDao.getId(), totalCost);
                System.out.println(output);
            }


        } else {
            System.out.println("No arguments");
        }
    }

    private static Vehicle getVehicle(VehicleInfo vehicleInfoDao) {
        Vehicle vehicle = getVehicle(vehicleInfoDao.getVehicleTypeName(), vehicleInfoDao.getAge(), vehicleInfoDao.getNumberOfMiles(), vehicleInfoDao.isDiesel());
        return vehicle;
    }

    private static String applyStringFunction(StringFunction stringFunction, String input) {
        return stringFunction.appy(input);
    }

    private static int applyCalculateFormula(Formula formula, Vehicle vehicle) {
        return formula.calculate(vehicle);
    }

    private static Vehicle getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel) {
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
