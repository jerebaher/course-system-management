package com.practices.msvc.course.repository;

import com.practices.msvc.course.models.abstracts.PersistentAbstractEntity;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T extends PersistentAbstractEntity>  {
    public List<T> getAll();
    public Optional<T> getByOid(Long oid);
    public void save(T t);
}
