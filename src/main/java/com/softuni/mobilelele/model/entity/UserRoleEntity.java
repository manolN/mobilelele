package com.softuni.mobilelele.model.entity;

import com.softuni.mobilelele.model.entity.enums.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public UserRoleEntity() {
    }

    public RoleEnum getName() {
        return name;
    }

    public UserRoleEntity setName(RoleEnum name) {
        this.name = name;
        return this;
    }
}
