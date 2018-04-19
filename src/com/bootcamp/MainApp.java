package com.bootcamp;

import com.bootcamp.formula.Formula;
import com.bootcamp.service.InsuranceCalculationResult;
import com.bootcamp.service.InsuranceCalculatorService;
import com.bootcamp.vehicle.Vehicle;

import java.util.List;

public class MainApp {
    private static final String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";


    public static void main(String[] args) {

        if (args.length >= 1) {
            final InsuranceCalculatorService service = new InsuranceCalculatorService(args[0]);
            List<InsuranceCalculationResult> resultList = service.calculateAll();
            for (InsuranceCalculationResult result : resultList) {
                final String output = String.format(OUTPUT_FORMAT, result.getId(), result.getCost());
                System.out.println(output);
            }
        } else {
            System.out.println("No arguments");
        }
    }


    private static String applyStringFunction(StringFunction stringFunction, String input) {
        return stringFunction.appy(input);
    }

    private static int applyCalculateFormula(Formula formula, Vehicle vehicle) {
        return formula.calculate(vehicle);
    }


}
