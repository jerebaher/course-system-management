package com.practices.msvc.course.models.abstracts;

public abstract class DtoAbstract<E extends PersistentAbstractEntity> {
    protected final Long oid;
    protected final Boolean deleted;

    protected DtoAbstract(E e) {
        this.oid = e.getOid();
        this.deleted = e.getDeleted();
    }

    public Long getOid() {
        return oid;
    }

    public Boolean getDeleted() {
        return deleted;
    }
}
