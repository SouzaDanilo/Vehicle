package com.webapp.veiculos.controller;

import com.webapp.veiculos.model.Vehicle;
import com.webapp.veiculos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        Vehicle response = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle,@PathVariable Long id){
        Vehicle response = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle>findVehicle(@PathVariable Long id){
        Vehicle response = vehicleService.getVehicle(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>>findAllByFilter(@RequestParam (value = "brand", required = false) String brand,
                                                        @RequestParam (value = "car", required = false) String car){

        List<Vehicle> listResponse = new ArrayList<>();
        if(!StringUtils.isEmpty(brand) || !StringUtils.isEmpty(car)){
            listResponse = vehicleService.findAllByFilter(brand,car);
        } else {
            listResponse = vehicleService.findAll();

        }
        return ResponseEntity.ok().body(listResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id){
        vehicleService.delete(id);
        return ResponseEntity.ok().build();
    }

}
