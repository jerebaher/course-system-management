package com.practices.msvc.course.repository;

import com.practices.msvc.course.models.entity.Course;

import java.time.LocalDate;
import java.util.Optional;

public interface CourseRepository extends GenericRepository<Course> {
    public Optional<Course> getByName(String name);
    public Optional<Course> getByStartDate(LocalDate startDate);
    public Optional<Course> getByFinishDate(LocalDate finishDate);
}
