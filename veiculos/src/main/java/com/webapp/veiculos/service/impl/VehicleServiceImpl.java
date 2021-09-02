package com.webapp.veiculos.service.impl;

import com.webapp.veiculos.model.Vehicle;
import com.webapp.veiculos.repository.VehicleRepository;
import com.webapp.veiculos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public Vehicle saveVehicle(Vehicle vehicle){

        if(vehicle.getId() != null && vehicleRepository.findVehicle(vehicle.getId()) == null){
            throw new EntityNotFoundException("Vehicle is not registered");
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vehicle is not registered"));
        return vehicle;
    }

    @Override
    public List<Vehicle> findAllByFilter(String brand, String car) {

        final List <Specification<Vehicle>> specifications = new ArrayList<>();

        if(!StringUtils.isEmpty(brand)) {
            specifications.add((root, query, cb) -> cb.equal(cb.upper(root.get("brand")), brand));
        }
        if(!StringUtils.isEmpty(car)) {
            specifications.add((root, query, cb) -> cb.equal(cb.upper(root.get("car")), car));
        }

        Specification<Vehicle> completeQuery = null;

        for(final Specification<Vehicle> specification : specifications) {

            if(completeQuery == null) {
                completeQuery = specification;
            } else {
                completeQuery = Specification.where(completeQuery).and(specification);
            }
        }

        return vehicleRepository.findAll(completeQuery);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

}
