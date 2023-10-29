package com.practices.msvc.user.repository.impl;

import com.practices.msvc.user.dao.UserDAO;
import com.practices.msvc.user.models.entity.User;
import com.practices.msvc.user.repository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserDAO userDAO;

    public UserRepositoryImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return this.userDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getByOid(Long oid) {
        return this.userDAO.findById(oid);
    }

    @Override
    @Transactional
    public void save(User user) {
        this.userDAO.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getByEmail(String email) {
        return this.userDAO.findByEmailAndDeletedFalse(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getByIdNumber(Long idNumber) {
        return this.userDAO.findByIdNumberAndDeletedFalse(idNumber);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<User>> getByName(String name) {
        return this.userDAO.findByNameStartingWithAndDeletedFalse(name);
    }
}
