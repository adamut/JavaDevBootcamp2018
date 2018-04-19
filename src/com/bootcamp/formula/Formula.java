package com.bootcamp.formula;

import com.bootcamp.vehicle.Vehicle;

public enum Formula {

    BUS_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            int cost = 200 * vehicle.getAge();
            cost += vehicle.isDiesel() ? 1000 : 0;
            cost += vehicle.getNumberOfMiles() > 100000 ? 500 : 0;
            cost += vehicle.getNumberOfMiles() > 200000 ? 500 : 0;
            return cost;
        }
    },
    CAR_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            int cost = 100 * vehicle.getAge();
            cost += vehicle.isDiesel() ? 500 : 0;
            cost += vehicle.getNumberOfMiles() > 200000 ? 500 : 0;
            return cost;
        }
    },
    TIPPER_FORMULA {
        @Override
        public int calculate(Vehicle vehicle) {
            int cost = 300 * vehicle.getAge();
            cost += vehicle.getNumberOfMiles() > 80000 ? 700 : 0;
            return cost;
        }
    };

    Formula() {
    }

    public abstract int calculate(Vehicle vehicle);
    }
