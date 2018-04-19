package com.bootcamp.dao.impl;

import com.bootcamp.dao.VehicleInfoDao;
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

public class VehicleInfoPlainFileDao implements VehicleInfoDao {
    private final String filePath;

    private static final String SEPARATOR = ";";

    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;

    public VehicleInfoPlainFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {
        final File inputFile = new File(this.filePath);
        final List<VehicleInfo> vehicleInfoList = new ArrayList<>();

        try {
            final InputStream inputStream = new FileInputStream(inputFile);
            final Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                final String[] tokens = line.split(SEPARATOR);

                vehicleInfoList.add(new VehicleInfo(tokens[VEHICLE_ID], tokens[VEHICLE_TYPE], tokens[VEHICLE_FORMULA], Integer.parseInt(tokens[VEHICLE_AGE]),
                        Long.parseLong(tokens[VEHICLE_MILES]), Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL])));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return vehicleInfoList;
    }
}
