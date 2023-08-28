package com.softuni.mobilelele.init;

import com.softuni.mobilelele.model.entity.*;
import com.softuni.mobilelele.model.entity.enums.CategoryEnum;
import com.softuni.mobilelele.model.entity.enums.EngineEnum;
import com.softuni.mobilelele.model.entity.enums.RoleEnum;
import com.softuni.mobilelele.model.entity.enums.TransmissionEnum;
import com.softuni.mobilelele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    private final OfferRepository offerRepository;
    private final ModelRepository modelRepository;

    public DBInit(BrandRepository brandRepository, UserRepository userRepository,
                  PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository,
                  OfferRepository offerRepository,
                  ModelRepository modelRepository) {

        this.brandRepository = brandRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) {
        initUserRoles();
        initBrandAndModels();
        initUsers();
        initOffers();
    }

    private void initOffers() {
        if (offerRepository.count() == 0) {
            Optional<UserEntity> admin = userRepository.findByUsername("admin");
            Optional<ModelEntity> fiesta = modelRepository.findById(Long.parseLong("1"));

            OfferEntity adminOffer = new OfferEntity();
            adminOffer.setEngine(EngineEnum.GASOLINE);
            adminOffer.setTransmission(TransmissionEnum.MANUAL);
            adminOffer.setMileage(20000);
            adminOffer.setPrice(35000.00);
            adminOffer.setYear(2017);
            adminOffer.setSeller(admin.get());
            adminOffer.setModel(fiesta.get());
            adminOffer.setImageUrl(fiesta.get().getImageUrl());
            adminOffer.setDescription("Very preserved Ford Fiesta on low mileage with manual transmission.");

            Optional<UserEntity> user = userRepository.findByUsername("pesho");
            Optional<ModelEntity> escort = modelRepository.findById(Long.parseLong("2"));

            OfferEntity userOffer = new OfferEntity();
            userOffer.setEngine(EngineEnum.GASOLINE);
            userOffer.setTransmission(TransmissionEnum.MANUAL);
            userOffer.setMileage(100000);
            userOffer.setPrice(17500.00);
            userOffer.setYear(1989);
            userOffer.setSeller(user.get());
            userOffer.setModel(escort.get());
            userOffer.setImageUrl(escort.get().getImageUrl());
            userOffer.setDescription("Old Ford Escort with high mileage and powerful gasoline engine.");

            offerRepository.saveAll(List.of(adminOffer, userOffer));
        }
    }

    private void initUserRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setName(RoleEnum.ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setName(RoleEnum.USER);

            userRoleRepository.saveAll(List.of(adminRole, userRole));
        }
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            UserRoleEntity adminRole = userRoleRepository.findByName(RoleEnum.ADMIN);
            UserRoleEntity userRole = userRoleRepository.findByName(RoleEnum.USER);

            UserEntity admin = new UserEntity();
            admin.setUsername("admin");
            admin.setActive(true);
            admin.setFirstName("Admin");
            admin.setLastName("Adminov");
            admin.setPassword(passwordEncoder.encode("test"));
            admin.setRoles(Set.of(userRole, adminRole));

            userRepository.save(admin);

            UserEntity pesho = new UserEntity();
            pesho.setUsername("pesho");
            pesho.setActive(true);
            pesho.setFirstName("Pesho");
            pesho.setLastName("Peshev");
            pesho.setPassword(passwordEncoder.encode("test"));
            pesho.setRoles(Set.of(userRole));

            userRepository.save(pesho);
        }
    }

    private void initBrandAndModels() {
        if (brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity();
            ford.setName("Ford");

            brandRepository.save(ford);
        }

        if (modelRepository.count() == 0) {
            BrandEntity ford = brandRepository.findByName("ford").get();

            ModelEntity fiesta = new ModelEntity();
            fiesta.setName("Fiesta");
            fiesta.setBrand(ford);
            fiesta.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/2017_Ford_Fiesta_Zetec_1.1_Front.jpg/420px-2017_Ford_Fiesta_Zetec_1.1_Front.jpg");
            fiesta.setCategory(CategoryEnum.CAR);
            fiesta.setYear(1976);

            ModelEntity escort = new ModelEntity();
            escort.setName("Escort");
            escort.setBrand(ford);
            escort.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/c/cc/Ford_Escort_3_by_seaside.jpg/413px-Ford_Escort_3_by_seaside.jpg");
            escort.setCategory(CategoryEnum.CAR);
            escort.setYear(1968);

            modelRepository.saveAll(List.of(fiesta, escort));
            ford.setModels(List.of(fiesta, escort));
            brandRepository.save(ford);
        }
    }
}