package com.softuni.mobilelele.model.view;

import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;

import java.time.Instant;

public class OfferDetailsView {

    private Long id;
    private EngineEnum engine;
    private Integer mileage;
    private Integer price;
    private TransmissionEnum transmission;
    private String imageUrl;
    private String brandName;
    private String modelName;
    private Instant created;
    private Integer year;
    private Instant modified;
    private String sellerFullName;
    private String description;

    public Long getId() {
        return id;
    }

    public OfferDetailsView setId(Long id) {
        this.id = id;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferDetailsView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferDetailsView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferDetailsView setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferDetailsView setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public OfferDetailsView setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public OfferDetailsView setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public OfferDetailsView setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferDetailsView setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public OfferDetailsView setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
