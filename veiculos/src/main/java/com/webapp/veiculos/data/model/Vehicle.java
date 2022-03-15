package com.webapp.veiculos.data.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {

    private static final long serializationUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    @NotNull(message = "brand is a mandatory field")
    private String brand;

    @Column(name = "car")
    @NotNull(message = "car is a mandatory field")
    private String car;

    @Column(name = "installments")
    @NotNull(message = "installments is a mandatory field")
    private Integer installments;

    @Column(name = "price")
    @NotNull(message = "price is mandatory field")
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Vehicle(Long id, String brand, String car, Integer installments, Integer price) {
        this.id = id;
        this.brand = brand;
        this.car = car;
        this.installments = installments;
        this.price = price;
    }

    public Vehicle(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id.equals(vehicle.id) && brand.equals(vehicle.brand) && car.equals(vehicle.car) && installments.equals(vehicle.installments) && price.equals(vehicle.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, car, installments, price);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", car='" + car + '\'' +
                ", installments=" + installments +
                ", price=" + price +
                '}';
    }
}
