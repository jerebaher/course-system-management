package com.practices.msvc.user.repository;

import com.practices.msvc.user.models.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends GenericRepository<User>{
    public Optional<User> getByEmail(String email);
    public Optional<User> getByIdNumber(Long idNumber);
    public Optional<List<User>> getByName(String name);
}
