package com.practices.msvc.course.models.abstracts;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class PersistentAbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long oid;

    @Column(name = "deleted_")
    protected Boolean deleted;

    protected PersistentAbstractEntity() {
        this.deleted = Boolean.FALSE;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
