package com.practices.msvc.course.models.entity;

import com.practices.msvc.course.models.abstracts.PersistentAbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class CourseUser extends PersistentAbstractEntity {
    @Column(name = "user_oid", unique = true)
    private Long userOid;

    public Long getUserOid() {
        return userOid;
    }

    public void setUserOid(Long userOid) {
        this.userOid = userOid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseUser that = (CourseUser) o;
        return Objects.equals(getUserOid(), that.getUserOid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserOid());
    }
}
