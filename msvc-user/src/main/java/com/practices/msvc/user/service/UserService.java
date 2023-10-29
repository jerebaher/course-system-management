package com.practices.msvc.user.service;

import com.practices.msvc.user.models.entity.User;
import com.practices.msvc.user.exception.ServiceLayerException;

import java.util.List;

public interface UserService extends GenericService<User>{
    public User getByEmail(String email) throws ServiceLayerException;
    public User getByIdNumber(Long idNumber) throws ServiceLayerException;
    public List<User> getByName(String name) throws ServiceLayerException;
}
