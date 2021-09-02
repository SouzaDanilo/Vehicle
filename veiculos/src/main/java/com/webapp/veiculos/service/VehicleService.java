package com.webapp.veiculos.service;

import com.webapp.veiculos.model.Vehicle;

import java.util.List;

public interface VehicleService {

    public Vehicle saveVehicle(Vehicle vehicle);
    public Vehicle getVehicle(Long id);
    public List<Vehicle> findAllByFilter(String brand, String car);
    public List<Vehicle> findAll();
    public void delete(Long id);
}
