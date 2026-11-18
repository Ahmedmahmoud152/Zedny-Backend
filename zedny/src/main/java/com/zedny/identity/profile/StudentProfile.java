package com.zedny.identity.profile;


import com.zedny.identity.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_profiles")
@Getter
@Setter
@NoArgsConstructor
public class StudentProfile {

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

    @Column(unique = true, length = 50)
    private String studentCode;

    @Column(length = 150)
    private String guardianName;

    @Column(length = 20)
    private String guardianPhone;
}

