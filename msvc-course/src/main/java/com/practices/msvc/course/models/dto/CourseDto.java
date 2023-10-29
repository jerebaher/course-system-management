package com.practices.msvc.course.models.dto;

import com.practices.msvc.course.models.abstracts.DtoAbstract;
import com.practices.msvc.course.models.entity.Course;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CourseDto extends DtoAbstract<Course> implements Serializable {
    private final Long id;
    private final String name;
    private final LocalDate startDate;
    private final LocalDate finishDate;

    public CourseDto(Course course) {
        super(course);
        this.id = course.getId();
        this.name = course.getName();
        this.startDate = course.getStartDate();
        this.finishDate = course.getFinishDate();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto entity = (CourseDto) o;
        return Objects.equals(this.oid, entity.oid) &&
                Objects.equals(this.deleted, entity.deleted) &&
                Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.startDate, entity.startDate) &&
                Objects.equals(this.finishDate, entity.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, deleted, id, name, startDate, finishDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "oid = " + oid + ", " +
                "deleted = " + deleted + ", " +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "startDate = " + startDate + ", " +
                "finishDate = " + finishDate + ")";
    }
}