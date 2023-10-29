package com.practices.msvc.course.controller;

import com.practices.msvc.course.exception.ServiceLayerException;
import com.practices.msvc.course.models.entity.Course;
import com.practices.msvc.course.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseController.class);

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Object> getAll(){
        try {
            List<Course> course = this.courseService.getAll();
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (ServiceLayerException e){
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "/user/oid/{oid}",produces = "application/json")
    public ResponseEntity<Object> getByOid(@PathVariable Long oid){
        try {
            Course course = this.courseService.getByOid(oid);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (ServiceLayerException e){
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "/course/{name}", produces = "application/json")
    public ResponseEntity<Object> getByName(@PathVariable String name){
        try {
            Course course = this.courseService.getByName(name);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (ServiceLayerException e){
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "/course/start-date", produces = "application/json")
    public ResponseEntity<Object> getByStartDate(@RequestParam LocalDate startDate){
        try {
            Course course = this.courseService.getByStartDate(startDate);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (ServiceLayerException e){
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path = "/course/finish-date", produces = "application/json")
    public ResponseEntity<Object> getByFinishDate(@RequestParam LocalDate finishDate){
        try {
            Course course = this.courseService.getByFinishDate(finishDate);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (ServiceLayerException e){
            LOGGER.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
