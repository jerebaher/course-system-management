package com.practices.msvc.user.models.entity;

import com.practices.msvc.user.models.abstracts.PersistentAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User extends PersistentAbstractEntity {

    @Column(unique = true, name = "dni")
    private Long idNumber;
    private String name;
    private String lastName;
    @Column(unique = true)
    @Email
    private String email;
    @NotEmpty(message = "It is necessary set a password")
    private String password;
    private LocalDate birthday;

    public User() {
    }

    public User(Long idNumber, String name, String lastName, String email, String password, LocalDate birthday) {
        this.idNumber = idNumber;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
