package com.bootcamp;

import com.bootcamp.calculator.InsurancePolicyCalculator;
import com.bootcamp.formula.Formula;
import com.bootcamp.vehicle.Bus;
import com.bootcamp.vehicle.Car;
import com.bootcamp.vehicle.Tipper;
import com.bootcamp.vehicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class MainApp {

    private static final String SEPARATOR = ";";

    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;

    public static void main(String[] args) {

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        if (args.length >= 1) {
            final File inputFile = new File(args[0]);
            try {
                final InputStream inputStream = new FileInputStream(inputFile);
                final Scanner scanner = new Scanner(inputStream);
                while (scanner.hasNextLine()) {
                    final String line = scanner.nextLine();
                    final String[] tokens = line.split(SEPARATOR);

                    final Vehicle vehicle =
                            getVehicle(tokens[VEHICLE_TYPE], Integer.parseInt(tokens[VEHICLE_AGE]),
                                    Long.parseLong(tokens[VEHICLE_MILES]), Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));
                    final Formula formula = Formula.valueOf(tokens[VEHICLE_FORMULA]);

                    final int totalCost = calculator.calculate(vehicle, formula);

                    final String output = String.format("Vehicle with id %s has total cost %d", tokens[VEHICLE_ID], totalCost);
                    System.out.println(output);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No arguments");
        }

        System.out.println(args.length);
        System.out.println(args[0]);
       /* System.out.println("Joe's policy cost is :" + calculator.calculate(stevensBus, Formula.BUS_FORMULA));
        System.out.println("Steve's policy cost is :" + calculator.calculate(joesCar, Formula.CAR_FORMULA));
        System.out.println("Peter's policy cost is :" + calculator.calculate(petersTipper, Formula.TIPPER_FORMULA));
   */
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
