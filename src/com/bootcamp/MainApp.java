package com.bootcamp;

import com.bootcamp.calculator.InsurancePolicyCalculator;
import com.bootcamp.formula.BusBasicFormula;
import com.bootcamp.formula.CarBasicFormula;
import com.bootcamp.formula.Formula;
import com.bootcamp.formula.TipperBasicFormula;
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

        final Formula carBasicFormula = new CarBasicFormula();
        final Formula busBasicFormula = new BusBasicFormula();
        final Formula tipperBasicFormula = new TipperBasicFormula();

        final int joesInsurancePolicyCost = calculator.calculate(joesCar,carBasicFormula);
        final int stevesInsurancePolicyCost = calculator.calculate(stevensBus,busBasicFormula);
        final int petersInsurancePolicyCost = calculator.calculate(petersTipper,tipperBasicFormula);

        System.out.println("Joe's policy cost is :" + joesInsurancePolicyCost);
        System.out.println("Steve's policy cost is :" + stevesInsurancePolicyCost);
        System.out.println("Peter's policy cost is :" + petersInsurancePolicyCost);

    }
}
