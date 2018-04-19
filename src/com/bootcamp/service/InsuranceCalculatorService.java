package com.bootcamp.service;

import com.bootcamp.calculator.InsurancePolicyCalculator;
import com.bootcamp.dao.impl.VehicleInfoPlainFileDao;
import com.bootcamp.formula.Formula;
import com.bootcamp.model.VehicleInfo;
import com.bootcamp.vehicle.Vehicle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.bootcamp.service.ConversionUtils.getVehicle;


public final class InsuranceCalculatorService {
    private String finalPath;


    public InsuranceCalculatorService(String finalPath) {
        this.finalPath = finalPath;
    }

    public List<InsuranceCalculationResult> calculateAll() {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
        final VehicleInfoPlainFileDao vehicleInfoPlainFileDao = new VehicleInfoPlainFileDao(finalPath);
        final List<VehicleInfo> listOfVehicles = vehicleInfoPlainFileDao.getAllVehicles();
        final List<InsuranceCalculationResult> resultList = new LinkedList<>();

        if (listOfVehicles.isEmpty()) {
            return Collections.emptyList();
        } else {
            for (VehicleInfo vehicleInfoDao : vehicleInfoPlainFileDao.getAllVehicles()) {
                final Vehicle vehicle = getVehicle(vehicleInfoDao.getVehicleTypeName(), vehicleInfoDao.getAge(), vehicleInfoDao.getNumberOfMiles(), vehicleInfoDao.isDiesel());
                final Formula formula = Formula.valueOf(vehicleInfoDao.getVehicleTypeFormula());
                final int totalCost = calculator.calculate(vehicle, formula);
                final InsuranceCalculationResult result = new InsuranceCalculationResult(vehicleInfoDao.getId(), totalCost);
                resultList.add(result);
            }
        }
        return resultList;
    }
}
