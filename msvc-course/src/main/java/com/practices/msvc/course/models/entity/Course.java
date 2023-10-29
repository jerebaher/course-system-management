package com.practices.msvc.course.models.entity;

import com.practices.msvc.course.models.abstracts.PersistentAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Course extends PersistentAbstractEntity {

    @Column(name = "course_id", unique = true)
    private Long id;
    @Column(name = "course_name")
    @NotEmpty(message = "It is necessary to define a name for the course")
    private String name;
    @NotNull(message = "It is necessary to define the start date of the course")
    private LocalDate startDate;
    @NotNull(message = "It is necessary to define the finish date of the course")
    private LocalDate finishDate;

    public Course() {
    }

    public Course(Long id, String name, LocalDate startDate, LocalDate finishDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
}
