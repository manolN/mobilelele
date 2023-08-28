package com.softuni.mobilelele.model.service;

import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;

public class OfferUpdateServiceModel {

    private Long id;
    private EngineEnum engine;
    private Integer mileage;
    private Integer price;
    private TransmissionEnum transmission;
    private String imageUrl;
    private String modelName;
    private Integer year;
    private String description;

    public Long getId() {
        return id;
    }

    public OfferUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferUpdateServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferUpdateServiceModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferUpdateServiceModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferUpdateServiceModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public OfferUpdateServiceModel setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferUpdateServiceModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
