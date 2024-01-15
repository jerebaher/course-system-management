package com.practices.msvc.course.service.impl;

import com.practices.msvc.course.exception.ServiceLayerException;
import com.practices.msvc.course.message.ErrorMessages;
import com.practices.msvc.course.models.dto.CourseDto;
import com.practices.msvc.course.models.entity.Course;
import com.practices.msvc.course.repository.CourseRepository;
import com.practices.msvc.course.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

    private static final String PREFIXED_MESSAGE_SERVICE = "Service error: ";

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course getByName(String name) throws ServiceLayerException{
        try {
            Optional<Course> courseOpt = this.courseRepository.getByName(name);
            if (courseOpt.isEmpty()) throw new ServiceLayerException(ErrorMessages.ENTITY_NOT_FOUND);
            return courseOpt.get();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceLayerException(PREFIXED_MESSAGE_SERVICE + ErrorMessages.ERROR_GETTING_ENTITY);
        }
    }

    @Override
    public Course getByStartDate(LocalDate startDate) throws ServiceLayerException{
        try {
            Optional<Course> courseOpt = this.courseRepository.getByStartDate(startDate);
            if (courseOpt.isEmpty()) throw new ServiceLayerException(ErrorMessages.ENTITY_NOT_FOUND);
            return courseOpt.get();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceLayerException(PREFIXED_MESSAGE_SERVICE + ErrorMessages.ERROR_GETTING_ENTITY);
        }
    }

    @Override
    public Course getByFinishDate(LocalDate finishDate) throws ServiceLayerException{
        try {
            Optional<Course> courseOpt = this.courseRepository.getByFinishDate(finishDate);
            if (courseOpt.isEmpty()) throw new ServiceLayerException(ErrorMessages.ENTITY_NOT_FOUND);
            return courseOpt.get();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceLayerException(PREFIXED_MESSAGE_SERVICE + ErrorMessages.ERROR_GETTING_ENTITY);
        }
    }

    @Override
    public List<Course> getAll() throws ServiceLayerException {
        try {
            return this.courseRepository.getAll();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceLayerException(PREFIXED_MESSAGE_SERVICE + ErrorMessages.ERROR_GETTING_ENTITY);
        }
    }

    @Override
    public Course getByOid(Long oid) throws ServiceLayerException {
        try {
            Course course = this.courseRepository.getByOid(oid).orElse(null);
            if (course == null) throw new ServiceLayerException("Service error: course do not exist.");

            return course;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new ServiceLayerException(PREFIXED_MESSAGE_SERVICE + ErrorMessages.ERROR_GETTING_ENTITY);
        }
    }

    @Override
    public void save(CourseDto courseDto) throws ServiceLayerException {
        try {
            Course course = this.getByOid(courseDto.getOid());
            if (courseDto.getId() != null && !course.getId().equals(courseDto.getId())){
                course.setId(course.getId());
            }
            if (courseDto.getDeleted() != null && !course.getDeleted().equals(courseDto.getDeleted())){
                course.setDeleted(courseDto.getDeleted());
            }
            if (courseDto.getName() != null && !course.getName().equals(courseDto.getName())){
                course.setName(courseDto.getName());
            }
            if (courseDto.getStartDate() != null && course.getStartDate().equals(courseDto.getStartDate())){
                course.setStartDate(courseDto.getStartDate());
            }
            if (courseDto.getFinishDate() != null && course.getFinishDate().equals(courseDto.getFinishDate())){
                course.setFinishDate(courseDto.getFinishDate());
            }

            this.courseRepository.save(course);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            throw new ServiceLayerException(PREFIXED_MESSAGE_SERVICE + ErrorMessages.ERROR_GETTING_ENTITY);
        }
    }
}
