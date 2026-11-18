
package com.zedny.academics.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CenterCourseRepository
        extends JpaRepository<CenterCourse, Long> {

    Optional<CenterCourse> findByCenterIdAndCourseId(
            Long centerId,
            Long courseId
    );

    boolean existsByCenterIdAndCourseId(
            Long centerId,
            Long courseId
    );

    List<CenterCourse> findByCenterId(Long centerId);

    List<CenterCourse> findByCourseId(Long courseId);
}
