package com.insurance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VehicleInsurance {

    private static final String VEHICLE_SYMBOLS_FILE = "vehicle_symbols.csv";
    private static final String BASE_RATES_FILE = "base_rates.csv";
    private static final String UPDATE_DATA_FILE = "update_data.csv";
    private static final String TERRITORY_FACTORS_FILE = "territory_factors.csv";

    // Define data structures to store table data
    private static Map<String, String> vehicleSymbols = new HashMap<>();
    private static Map<String, String> baseRates = new HashMap<>();
    private static Map<String, String> territoryFactors = new HashMap<>();

    public static void main(String[] args) {
        loadDataFromCSV();
        updateTablesFromCSV();
        
        // Example inputs
        //Ford, Ranger, 2018, 1
        //Ford, Taurus, 2013, 2
        //Ford, Taurus, 2018, 3
        //Ford, Escort, 2019, 4
        //Chevrolet, Impala, 2022, 2
        //Chevrolet, Suburban, 2022, 3
        String make = "Chevrolet";
        String model = "Impala";
        int year = 2022;
        int territory = 2;

        String vehicleSymbol = getVehicleSymbol(make, model, year);
        String baseRate = getBaseRate(vehicleSymbol);
        int rate = calculateRate(baseRate, territory);

        System.out.println("Rate: " + rate);
        System.out.println("VehicleSymbol: " + vehicleSymbol);
    }

    // Step 1: Load data from CSV files
    private static void loadDataFromCSV() {
        loadVehicleSymbols();
        loadBaseRates();
        loadTerritoryFactors();
    }

    private static void loadVehicleSymbols() {
        try (BufferedReader br = new BufferedReader(new FileReader(VEHICLE_SYMBOLS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String key = parts[0] + "_" + parts[1] + "_" + parts[2];
                vehicleSymbols.put(key, parts[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadBaseRates() {
        try (BufferedReader br = new BufferedReader(new FileReader(BASE_RATES_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                baseRates.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadTerritoryFactors() {
        try (BufferedReader br = new BufferedReader(new FileReader(TERRITORY_FACTORS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                territoryFactors.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Step 2: Update tables from update data CSV
    private static void updateTablesFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(UPDATE_DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String key = parts[0] + "_" + parts[1] + "_" + parts[2];
                String symbol = parts[3];
                int baseRate = Integer.parseInt(parts[4]);

                vehicleSymbols.put(key, symbol);
                if (baseRate != 0) {
                    baseRates.put(symbol, String.valueOf(baseRate));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Step 3: Get the correct symbol from the updated VehicleSymbols table
    private static String getVehicleSymbol(String make, String model, int year) {
        String key = make + "_" + model + "_" + year;
        return vehicleSymbols.getOrDefault(key, "Invalid Input");
    }

    // Step 4: Get the BaseRate using the VehicleSymbol
    private static String getBaseRate(String vehicleSymbol) {
        return baseRates.getOrDefault(vehicleSymbol, String.valueOf(0));
    }

    // Step 5: Calculate the rate using BaseRate and TerritoryFactor
    private static int calculateRate(String baseRate, int territory) {
        double territoryFactor = Double.parseDouble(territoryFactors.getOrDefault(String.valueOf(territory), String.valueOf(0)));
        double rate = Integer.parseInt(baseRate) * territoryFactor;
        return (int) Math.ceil(rate);
    }
}
