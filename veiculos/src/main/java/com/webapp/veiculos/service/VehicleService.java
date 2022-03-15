package com.webapp.veiculos.service;

import com.webapp.veiculos.data.model.Vehicle;
import com.webapp.veiculos.data.vo.VehicleVO;

import java.util.List;

public interface VehicleService {

    public VehicleVO saveVehicle(VehicleVO vehicle);
    public VehicleVO getVehicle(Long id);
    public List<VehicleVO> findAllByFilter(String brand, String car);
    public List<VehicleVO> findAll();
    public void delete(Long id);
}
