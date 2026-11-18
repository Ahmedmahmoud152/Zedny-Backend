package com.zedny.identity.permission;

import com.zedny.identity.permission.RolePermission;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "permissions",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_permissions_code",
                        columnNames = "code"
                ),
                @UniqueConstraint(
                        name = "uk_permissions_name",
                        columnNames = "name"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false, length = 150)
    private String code;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, length = 100)
    private String module;

    private LocalDateTime createdAt;

    @OneToMany(
            mappedBy = "permission",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<RolePermission> rolePermissions = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
