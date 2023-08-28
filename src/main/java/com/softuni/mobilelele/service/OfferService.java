package com.softuni.mobilelele.service;

import com.softuni.mobilelele.model.service.OfferAddServiceModel;
import com.softuni.mobilelele.model.service.OfferUpdateServiceModel;
import com.softuni.mobilelele.model.view.OfferDetailsView;
import com.softuni.mobilelele.model.view.OfferSummaryView;;

import java.security.Principal;
import java.util.List;

public interface OfferService {

    List<OfferSummaryView> findAllOffers();

    OfferDetailsView findOfferById(Long id);

    void deleteOffer(Long id);

    boolean isOwner(String username, Long id);

    void updateOffer(OfferUpdateServiceModel serviceModel);

    void addOffer(OfferAddServiceModel addServiceModel, Principal principal);
}
