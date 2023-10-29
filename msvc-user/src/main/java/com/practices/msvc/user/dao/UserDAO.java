package com.practices.msvc.user.dao;

import com.practices.msvc.user.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserDAO extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndDeletedFalse(String email);
    Optional<User> findByIdNumberAndDeletedFalse(Long idNumber);
    Optional<List<User>> findByNameStartingWithAndDeletedFalse(String name);
}
