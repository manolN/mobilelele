package com.softuni.mobilelele.web;

import com.softuni.mobilelele.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands/all")
    public String allBrands(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());

        return "brands";
    }
}