package com.practices.msvc.course.service;

import com.practices.msvc.course.exception.ServiceLayerException;
import com.practices.msvc.course.models.abstracts.DtoAbstract;
import com.practices.msvc.course.models.abstracts.PersistentAbstractEntity;

import java.util.List;

public interface GenericService<T extends PersistentAbstractEntity, D extends DtoAbstract<T>> {
    public List<T> getAll() throws ServiceLayerException;
    public T getByOid(Long oid) throws ServiceLayerException;
    public void save(D d) throws ServiceLayerException;
}
