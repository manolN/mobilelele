package com.softuni.mobilelele.web;

import com.softuni.mobilelele.model.binding.OfferAddBindingModel;
import com.softuni.mobilelele.model.binding.OfferUpdateBindingModel;
import com.softuni.mobilelele.model.entity.enums.CategoryEnum;
import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;
import com.softuni.mobilelele.model.service.OfferAddServiceModel;
import com.softuni.mobilelele.model.service.OfferUpdateServiceModel;
import com.softuni.mobilelele.model.view.OfferDetailsView;
import com.softuni.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class OffersController {

    private final OfferService offerService;
    private final ModelMapper mapper;

    public OffersController(OfferService offerService, ModelMapper mapper) {
        this.offerService = offerService;
        this.mapper = mapper;
    }

    // GET
    @GetMapping("/offers/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.findAllOffers());

        return "offers";
    }

    @GetMapping("/offers/{id}/details")
    public String offerDetails(@PathVariable Long id, Model model, Principal principal) {
        model.addAttribute("offer", offerService.findOfferById(id));
        model.addAttribute("isOwner", offerService.isOwner(principal.getName(), id));

        return "details";
    }

    // DELETE
    @PreAuthorize("@offerServiceImpl.isOwner(#principal.name, #id)")
    @DeleteMapping("/offers/{id}")
    public String deleteOffer(@PathVariable Long id, Principal principal) {
        offerService.deleteOffer(id);

        return "redirect:/offers/all";
    }

    // UPDATE
    @GetMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, Model model) {
        OfferDetailsView offerById = offerService.findOfferById(id);
        OfferUpdateBindingModel offerUpdateBindingModel = mapper.map(offerById, OfferUpdateBindingModel.class);

        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        model.addAttribute("offerUpdateBindingModel", offerUpdateBindingModel);

        return "update";
    }

    @PatchMapping("/offers/{id}/edit")
    public String editOffer(@PathVariable Long id, @Valid OfferUpdateBindingModel offerUpdateBindingModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerUpdateBindingModel", offerUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerUpdateBindingModel", bindingResult);

            return "redirect:/offers/" + id + "/edit";
        }

        OfferUpdateServiceModel serviceModel = mapper.map(offerUpdateBindingModel, OfferUpdateServiceModel.class);
        serviceModel.setId(id);
        offerService.updateOffer(serviceModel);

        return "redirect:/offers/" + id + "/details";
    }

    // CREATE
    @GetMapping("/offers/add")
    public String addOffer(Model model) {
        model.addAttribute("engines", EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        model.addAttribute("categories", CategoryEnum.values());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid OfferAddBindingModel offerAddBindingModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes, Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel",
                            bindingResult);

            return "redirect:/offers/add";
        }

        OfferAddServiceModel addServiceModel = mapper.map(offerAddBindingModel, OfferAddServiceModel.class);
        offerService.addOffer(addServiceModel, principal);

        return "redirect:/offers/all";
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }
}