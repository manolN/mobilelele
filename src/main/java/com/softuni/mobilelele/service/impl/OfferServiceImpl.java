package com.softuni.mobilelele.service.impl;

import com.softuni.mobilelele.model.entity.*;
import com.softuni.mobilelele.model.entity.enums.RoleEnum;
import com.softuni.mobilelele.model.service.OfferAddServiceModel;
import com.softuni.mobilelele.model.service.OfferUpdateServiceModel;
import com.softuni.mobilelele.model.view.OfferDetailsView;
import com.softuni.mobilelele.model.view.OfferSummaryView;
import com.softuni.mobilelele.repository.BrandRepository;
import com.softuni.mobilelele.repository.ModelRepository;
import com.softuni.mobilelele.repository.OfferRepository;
import com.softuni.mobilelele.repository.UserRepository;
import com.softuni.mobilelele.service.OfferService;
import com.softuni.mobilelele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public OfferServiceImpl(OfferRepository offerRepository, ModelRepository modelRepository,
                            BrandRepository brandRepository, ModelMapper mapper,
                            UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<OfferSummaryView> findAllOffers() {
        List<OfferSummaryView> collected = offerRepository.findAll()
                .stream()
                .map(offer -> {
                    return mapper
                            .map(offer, OfferSummaryView.class)
                            .setBrandName(offer.getModel().getBrand().getName());
                })
                .collect(Collectors.toList());

        return collected;
    }

    @Override
    public OfferDetailsView findOfferById(Long id) {
        OfferEntity offerById = offerRepository.findById(id).orElse(null);

        return mapper.map(offerById, OfferDetailsView.class)
                .setSellerFullName(offerById.getSeller().getFirstName() + " " + offerById.getSeller().getLastName())
                .setBrandName(offerById.getModel().getBrand().getName());
    }

    @Override
    public void deleteOffer(Long id) {
        OfferEntity offerEntity = offerRepository.findById(id).get();
        ModelEntity model = offerEntity.getModel();
        BrandEntity brandEntity = brandRepository.findByName(model.getBrand().getName()).get();

        List<ModelEntity> models = brandEntity.getModels();

        for (Iterator<ModelEntity> iterator = models.iterator(); iterator.hasNext(); ) {
            ModelEntity modelEntity = iterator.next();

            if (modelEntity.getId() == model.getId()) {
                iterator.remove();
                break;
            }
        }

        brandRepository.save(brandEntity);
        offerRepository.deleteById(id);
        modelRepository.deleteById(model.getId());
    }

    @Override
    public boolean isOwner(String username, Long id) {
        Optional<OfferEntity> optionalOffer = offerRepository.findById(id);
        Optional<UserEntity> caller = userRepository.findByUsername(username);

        if (optionalOffer.isEmpty() || caller.isEmpty()) {
            return false;
        }

        OfferEntity offerEntity = optionalOffer.get();

        return isAdmin(caller.get()) || offerEntity.getSeller().getUsername().equalsIgnoreCase(username);
    }

    private boolean isAdmin(UserEntity user) {
        return user.getRoles()
                .stream()
                .map(UserRoleEntity::getName)
                .anyMatch(r -> r == RoleEnum.ADMIN);
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel serviceModel) {
        OfferEntity offerEntity = offerRepository.findById(serviceModel.getId()).orElseThrow();
        offerEntity.setImageUrl(serviceModel.getImageUrl());
        offerEntity.setYear(serviceModel.getYear());
        offerEntity.setPrice(serviceModel.getPrice().doubleValue());
        offerEntity.setMileage(serviceModel.getMileage());
        offerEntity.setTransmission(serviceModel.getTransmission());
        offerEntity.setEngine(serviceModel.getEngine());
        offerEntity.setDescription(serviceModel.getDescription());
        offerEntity.setModified(Instant.now());

        offerRepository.save(offerEntity);

        // description in not mapped in form,
        // model has dropdown for brand,
        // offer details don't have description
    }

    @Override
    public void addOffer(OfferAddServiceModel addServiceModel, Principal principal) {
        BrandEntity brandEntity = createBrandIfNotExisting(addServiceModel.getBrand());

        ModelEntity modelEntity = mapper.map(addServiceModel, ModelEntity.class);
        modelEntity.setName(addServiceModel.getModel());
        modelEntity.setBrand(brandEntity);

        List<ModelEntity> allModels = brandEntity.getModels();
        allModels.add(modelEntity);
        brandEntity.setModels(allModels);
        brandRepository.save(brandEntity);
        modelRepository.save(modelEntity);

        OfferEntity offerEntity = mapper.map(addServiceModel, OfferEntity.class);
        offerEntity.setSeller(userRepository.findByUsername(principal.getName()).orElseThrow());
        offerEntity.setModel(modelEntity);

        offerRepository.save(offerEntity);
    }

    private BrandEntity createBrandIfNotExisting(String brandName) {
        Optional<BrandEntity> optionalBrand = brandRepository.findByName(brandName);

        if (optionalBrand.isEmpty()) {
            BrandEntity brandEntity = new BrandEntity();
            brandEntity.setName(brandName);
            brandEntity.setModels(new ArrayList<>());

            return brandEntity;
        }

        return optionalBrand.get();
    }
}