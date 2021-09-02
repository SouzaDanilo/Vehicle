package com.webapp.veiculos.repository;

import com.webapp.veiculos.model.Vehicle;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.id = :id")
    public Vehicle findVehicle(Long id);

    public List<Vehicle> findAll(Specification<Vehicle> completeQuery);

}
