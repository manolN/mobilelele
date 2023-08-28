package com.softuni.mobilelele.service.impl;

import com.softuni.mobilelele.model.view.BrandView;
import com.softuni.mobilelele.repository.BrandRepository;
import com.softuni.mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandView> getAllBrands() {
        return brandRepository
                .findAll()
                .stream()
                .map(b -> modelMapper.map(b, BrandView.class))
                .collect(Collectors.toList());
    }
}