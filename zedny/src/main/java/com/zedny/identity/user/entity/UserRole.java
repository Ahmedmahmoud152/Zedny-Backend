package com.zedny.identity.user.entity;



import com.zedny.identity.enums.ScopeType;
import com.zedny.identity.role.Role;
import com.zedny.identity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // References Center ID from the Center module
    @Column(name = "center_id")
    private Long centerId;

    @Enumerated(EnumType.STRING)
    @Column(name = "scope_type", nullable = false, length = 20)
    private ScopeType scopeType;

    @Column(nullable = false, updatable = false)
    private LocalDateTime assignedAt;

    @Column(nullable = false)
    private boolean isActive = true;

    @PrePersist
    protected void onCreate() {
        assignedAt = LocalDateTime.now();
    }
}

