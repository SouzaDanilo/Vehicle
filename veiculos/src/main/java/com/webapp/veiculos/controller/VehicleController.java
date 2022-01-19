package com.webapp.veiculos.controller;

import com.webapp.veiculos.data.vo.VehicleVO;
import com.webapp.veiculos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<VehicleVO> createVehicle(@Valid  @RequestBody VehicleVO vehicle){
        VehicleVO response = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleVO> updateVehicle(@RequestBody @Valid VehicleVO vehicle, @PathVariable Long id){
        VehicleVO response = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleVO>findVehicle(@PathVariable Long id){
        VehicleVO response = vehicleService.getVehicle(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<VehicleVO>>findAllByFilter(@RequestParam (value = "brand", required = false) String brand,
                                                        @RequestParam (value = "car", required = false) String car){

        List<VehicleVO> listResponse = new ArrayList<>();
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
