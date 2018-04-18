package com.bootcamp;

public final class InsurancePolicyCalculator {

    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    public int calculate(Vehicle vehicle, Formula formula) {
        return formula.calculate(vehicle);
    }

    private InsurancePolicyCalculator() {
    }
}
