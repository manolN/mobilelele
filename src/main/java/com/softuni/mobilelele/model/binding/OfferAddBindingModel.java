package com.softuni.mobilelele.model.binding;

import com.softuni.mobilelele.model.entity.enums.CategoryEnum;
import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OfferAddBindingModel {

    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotNull
    private CategoryEnum category;
    @NotNull
    private TransmissionEnum transmission;
    @NotNull
    private EngineEnum engine;
    @Min(1920)
    @NotNull
    private Integer year;
    @Min(0)
    @NotNull
    private Integer price;
    @Min(0)
    @NotNull
    private Integer mileage;
    private String description;
    private String imageUrl;

    public OfferAddBindingModel() {
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

    public OfferAddBindingModel setModel(String model) {
        this.model = model;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferAddBindingModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferAddBindingModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferAddBindingModel setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferAddBindingModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferAddBindingModel setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferAddBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}