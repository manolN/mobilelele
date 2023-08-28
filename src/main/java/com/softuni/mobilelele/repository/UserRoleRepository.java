package com.softuni.mobilelele.repository;

import com.softuni.mobilelele.model.entity.UserRoleEntity;
import com.softuni.mobilelele.model.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    UserRoleEntity findByName(RoleEnum role);
}
