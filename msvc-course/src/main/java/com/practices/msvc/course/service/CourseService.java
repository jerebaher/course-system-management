package com.practices.msvc.course.service;

import com.practices.msvc.course.exception.ServiceLayerException;
import com.practices.msvc.course.models.dto.CourseDto;
import com.practices.msvc.course.models.entity.Course;

import java.time.LocalDate;
import java.util.Optional;

public interface CourseService extends GenericService<Course, CourseDto> {
    public Course getByName(String name) throws ServiceLayerException;
    public Course getByStartDate(LocalDate startDate) throws ServiceLayerException;
    public Course getByFinishDate(LocalDate finishDate) throws ServiceLayerException;
}
