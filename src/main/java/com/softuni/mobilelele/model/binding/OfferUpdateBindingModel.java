package com.softuni.mobilelele.model.binding;

import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OfferUpdateBindingModel {

    private Long id;
    @NotNull
    private EngineEnum engine;
    @Min(0)
    private Integer mileage;
    @NotNull
    @Min(100)
    private Integer price;
    @NotNull
    private TransmissionEnum transmission;
    @NotBlank
    private String imageUrl;
    private String modelName;
    @NotNull
    @Min(1900)
    private Integer year;
    @NotBlank
    private String description;

    public Long getId() {
        return id;
    }

    public OfferUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferUpdateBindingModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferUpdateBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferUpdateBindingModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferUpdateBindingModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferUpdateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public OfferUpdateBindingModel setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferUpdateBindingModel setYear(Integer year) {
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