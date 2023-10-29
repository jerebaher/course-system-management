package com.practices.mcsvc.course;

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

    protected Long getOid() {
        return oid;
    }

    protected void setOid(Long oid) {
        this.oid = oid;
    }

    protected Boolean getDeleted() {
        return deleted;
    }

    protected void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
