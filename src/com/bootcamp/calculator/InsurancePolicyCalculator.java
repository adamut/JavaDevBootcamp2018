package com.bootcamp.calculator;

import com.bootcamp.formula.Formula;
import com.bootcamp.vehicle.Vehicle;

public final class InsurancePolicyCalculator {

    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    public int calculate(Vehicle vehicle, Formula formula) {
        return formula.calculate(vehicle);
    }

    private InsurancePolicyCalculator() {
    }
}
