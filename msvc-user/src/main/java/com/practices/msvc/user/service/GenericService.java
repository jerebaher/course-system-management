package com.practices.msvc.user.service;

import com.practices.msvc.user.exception.ServiceLayerException;
import com.practices.msvc.user.models.abstracts.PersistentAbstractEntity;

import java.util.List;

public interface GenericService<T extends PersistentAbstractEntity> {
    public List<T> getAll() throws ServiceLayerException;
    public T getByOid(Long oid) throws ServiceLayerException;
    public void save(T t) throws ServiceLayerException;
}
