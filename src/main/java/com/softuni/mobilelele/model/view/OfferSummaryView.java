package com.softuni.mobilelele.model.view;

import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;

import java.time.Instant;

public class OfferSummaryView {

    private Long id;
    private EngineEnum engine;
    private Integer mileage;
    private Integer price;
    private TransmissionEnum transmission;
    private String imageUrl;
    private String brandName;
    private String modelName;
    private Instant created;

    public Instant getCreated() {
        return created;
    }

    public OfferSummaryView setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public OfferSummaryView() {
    }

    public Long getId() {
        return id;
    }

    public OfferSummaryView setId(Long id) {
        this.id = id;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferSummaryView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferSummaryView setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public OfferSummaryView setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferSummaryView setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferSummaryView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public OfferSummaryView setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public OfferSummaryView setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }
}
