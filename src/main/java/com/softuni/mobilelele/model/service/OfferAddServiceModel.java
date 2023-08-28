package com.softuni.mobilelele.model.service;

import com.softuni.mobilelele.model.entity.enums.CategoryEnum;
import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;

public class OfferAddServiceModel {

    private String brand;
    private String model;
    private TransmissionEnum transmission;
    private EngineEnum engine;
    private CategoryEnum category;
    private Integer year;
    private Integer price;
    private Integer mileage;
    private String description;
    private String imageUrl;

    public OfferAddServiceModel() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public OfferAddServiceModel setModel(String model) {
        this.model = model;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public Integer getYear() {
        return year;
    }

    public OfferAddServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferAddServiceModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferAddServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
