package com.zedny.academics.group;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseGroupRepository
        extends JpaRepository<CourseGroup, Long> {

    List<CourseGroup> findByCenterCourseId(
            Long centerCourseId
    );

    List<CourseGroup> findByCenterCourseCenterId(
            Long centerId
    );

    List<CourseGroup> findByCenterCourseCourseId(
            Long courseId
    );
}

