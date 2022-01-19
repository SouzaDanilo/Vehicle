package com.webapp.veiculos.service.impl;

import com.webapp.veiculos.converter.DozerConverter;
import com.webapp.veiculos.data.vo.VehicleVO;
import com.webapp.veiculos.exception.ObjectNotFoundException;
import com.webapp.veiculos.data.model.Vehicle;
import com.webapp.veiculos.repository.VehicleRepository;
import com.webapp.veiculos.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public VehicleVO saveVehicle(VehicleVO vehicleVO){

        if(vehicleVO.getId() != null && vehicleRepository.findVehicle(vehicleVO.getId()) == null){
            throw new ObjectNotFoundException("Vehicle is not registered");
        }

        var entity = DozerConverter.parseObject(vehicleVO,Vehicle.class);
        var vo = DozerConverter.parseObject(vehicleRepository.save(entity), VehicleVO.class);
        return vo;
    }

    @Override
    public VehicleVO getVehicle(Long id) {
        var entity = vehicleRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Vehicle is not registered"));
        return DozerConverter.parseObject(entity,VehicleVO.class);
    }

    @Override
    public List<VehicleVO> findAllByFilter(String brand, String car) {

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
        return  DozerConverter.parseListObjects(vehicleRepository.findAll(completeQuery),VehicleVO.class);
    }

    @Override
    public List<VehicleVO> findAll() {
        return DozerConverter.parseListObjects(vehicleRepository.findAll(),VehicleVO.class);
    }

    @Override
    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

}
