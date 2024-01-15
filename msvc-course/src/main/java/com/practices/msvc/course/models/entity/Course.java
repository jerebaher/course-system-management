package com.practices.msvc.course.models.entity;

import com.practices.msvc.course.models.abstracts.PersistentAbstractEntity;
import com.practices.msvc.course.models.dto.UserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "course_oid")
    private List<CourseUser> courseUsers = new ArrayList<>();
    @Transient
    private List<UserDto> userList = new ArrayList<>();

    public Course() {}

    public Course(Long id, String name, LocalDate startDate, LocalDate finishDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public void addCourseUser (CourseUser courseUser){
        this.courseUsers.add(courseUser);
    }

    public void removeCourseUser(CourseUser courseUser){
        this.courseUsers.remove(courseUser);
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

    public List<CourseUser> getCourseUsers() {
        return courseUsers;
    }

    public void setCourseUsers(List<CourseUser> courseUsers) {
        this.courseUsers = courseUsers;
    }

    public List<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDto> userList) {
        this.userList = userList;
    }
}
