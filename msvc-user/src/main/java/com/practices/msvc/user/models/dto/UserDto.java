package com.practices.msvc.user.models.dto;

import com.practices.msvc.user.models.entity.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class UserDto implements Serializable {
    private final Long idNumber;
    private final String name;
    private final String lastName;
    private final String email;
    private final LocalDate birthday;

    public UserDto(Long idNumber, String name, String lastName, String email, LocalDate birthday) {
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }

    public UserDto(User user) {
        this.idNumber = user.getIdNumber();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.birthday = user.getBirthday();
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.idNumber, entity.idNumber) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.birthday, entity.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber, name, lastName, email, birthday);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idNumber = " + idNumber + ", " +
                "name = " + name + ", " +
                "lastName = " + lastName + ", " +
                "email = " + email + ", " +
                "birthday = " + birthday + ")";
    }
}