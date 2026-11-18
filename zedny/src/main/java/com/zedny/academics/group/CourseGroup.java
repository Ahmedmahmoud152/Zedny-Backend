
package com.zedny.academics.group;

import com.zedny.academics.course.CenterCourse;

import com.zedny.centers.Center;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(
        name = "course_groups",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_group_center_course_code",
                        columnNames = {"center_course_id", "code"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CourseGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id")
    private Center center;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "center_course_id",
            nullable = false
    )
    private CenterCourse centerCourse;

    @Positive
    private Integer capacity;

    private LocalDate startDate;

    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CourseGroupStatus status = CourseGroupStatus.ACTIVE;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}
