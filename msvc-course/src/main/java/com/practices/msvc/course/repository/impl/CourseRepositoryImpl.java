package com.practices.msvc.course.repository.impl;

import com.practices.msvc.course.dao.CourseDAO;
import com.practices.msvc.course.models.dto.UserDto;
import com.practices.msvc.course.models.entity.Course;
import com.practices.msvc.course.repository.CourseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private final CourseDAO courseDAO;

    public CourseRepositoryImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> getByName(String name) {
        return this.courseDAO.findCourseByNameAndDeletedFalse(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> getByStartDate(LocalDate startDate) {
        return this.courseDAO.findCourseByStartDate(startDate);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> getByFinishDate(LocalDate finishDate) {
        return this.courseDAO.findCourseByFinishDate(finishDate);
    }

    @Override
    public Optional<UserDto> assignUser(UserDto user, Long courseId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> createUser(UserDto user, Long courseId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> unassignUser(UserDto user, Long courseId) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAll() {
        return this.courseDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> getByOid(Long oid) {
        return this.courseDAO.findById(oid);
    }

    @Override
    @Transactional
    public void save(Course course) {
        this.courseDAO.save(course);
    }
}
