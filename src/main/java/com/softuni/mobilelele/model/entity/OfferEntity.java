package com.softuni.mobilelele.model.entity;

import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EngineEnum engine;
    @Column(nullable = false)
    private String imageUrl;
    private Integer mileage;
    @Column(nullable = false)
    private Double price;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransmissionEnum transmission;
    private Integer year;
    private Instant created;
    private Instant modified;
    @ManyToOne
    private ModelEntity model;
    @ManyToOne
    private UserEntity seller;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    @PrePersist
    public void beforeCreate() {
        this.created = Instant.now();
    }
}
