package com.practices.msvc.course.dao;

import com.practices.msvc.course.models.dto.UserDto;
import com.practices.msvc.course.models.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface CourseDAO extends JpaRepository<Course, Long> {
    public Optional<Course> findCourseByNameAndDeletedFalse(String name);
    public Optional<Course> findCourseByStartDate(LocalDate startDate);
    public Optional<Course> findCourseByFinishDate(LocalDate finishDate);
}
