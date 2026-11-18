package com.zedny.identity.permission;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "role_premission")
@Getter
@Setter
class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;

}