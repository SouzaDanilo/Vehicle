package com.webapp.veiculos.data.vo;

import java.io.Serializable;
import java.util.Objects;

public class VehicleVO implements Serializable {

    private static final long serializationUID = 1L;

    private Long id;
    private String brand;
    private String car;
    private Integer installments;
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

    public VehicleVO(Long id, String brand, String car, Integer installments, Integer price) {
        this.id = id;
        this.brand = brand;
        this.car = car;
        this.installments = installments;
        this.price = price;
    }

    public VehicleVO(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleVO vehicle = (VehicleVO) o;
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
