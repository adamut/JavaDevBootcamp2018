package com.bootcamp;

import com.bootcamp.calculator.InsurancePolicyCalculator;
import com.bootcamp.formula.Formula;
import com.bootcamp.vehicle.Bus;
import com.bootcamp.vehicle.Car;
import com.bootcamp.vehicle.Tipper;
import com.bootcamp.vehicle.Vehicle;

public class MainApp {

    public static void main(String[] args) {
        final Vehicle joesCar = new Car(5, 200000, true, "auto");
        final Vehicle stevensBus = new Bus(3, 100000, true, 31);
        final Vehicle petersTipper = new Tipper(6, 80000, false, 15);
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        final String inputString = "Ana has apples!";

      /*  System.out.println(applyStringFunction(StringFunction.TO_UPPER_FUNCTION, inputString));
        System.out.println(applyStringFunction(StringFunction.TO_LOWER_FUNCTION, inputString));
        System.out.println(applyStringFunction(StringFunction.TO_CHAR_FUNCTION, inputString));

      */
        System.out.println("Joe's policy cost is :" + calculator.calculate(stevensBus, Formula.BUS_FORMULA));
        System.out.println("Steve's policy cost is :" + calculator.calculate(joesCar, Formula.CAR_FORMULA));
        System.out.println("Peter's policy cost is :" + calculator.calculate(petersTipper, Formula.TIPPER_FORMULA));
    }

    private static String applyStringFunction(StringFunction stringFunction, String input) {
        return stringFunction.appy(input);
    }

    private static int applyCalculateFormula(Formula formula, Vehicle vehicle) {
        return formula.calculate(vehicle);
    }
}
