package com.zedny.identity.profile;


import com.zedny.identity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecturer_profiles")
@Getter
@Setter
@NoArgsConstructor
public class LecturerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            unique = true
    )
    private User user;

    @Column(length = 150)
    private String specialization;

    @Column(length = 200)
    private String qualification;

    private Integer experienceYears;
}

