package com.practices.msvc.user.service.impl;

import com.practices.msvc.user.models.entity.User;
import com.practices.msvc.user.exception.ServiceLayerException;
import com.practices.msvc.user.message.ErrorMessages;
import com.practices.msvc.user.repository.UserRepository;
import com.practices.msvc.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return this.userRepository.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getByOid(Long oid) throws ServiceLayerException {
        Optional<User> userOptional = this.userRepository.getByOid(oid);
        if (userOptional.isEmpty()) throw new ServiceLayerException(ErrorMessages.ENTITY_NOT_FOUND);

        return userOptional.get();
    }

    @Override
    @Transactional
    public void save(User user) throws ServiceLayerException {
        try {
            this.userRepository.save(user);
        } catch (Exception e) {
            throw new ServiceLayerException(ErrorMessages.CANNOT_SAVE_ENTITY);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email) throws ServiceLayerException {
        Optional<User> userOpt = this.userRepository.getByEmail(email);
        if (userOpt.isEmpty()) throw new ServiceLayerException(ErrorMessages.ENTITY_NOT_FOUND);

        return userOpt.get();
    }

    @Override
    @Transactional(readOnly = true)
    public User getByIdNumber(Long idNumber) throws ServiceLayerException {
        Optional<User> userOpt = this.userRepository.getByIdNumber(idNumber);
        if (userOpt.isEmpty()) {
            throw new ServiceLayerException(ErrorMessages.ENTITY_NOT_FOUND);
        }
        return userOpt.get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getByName(String name) throws ServiceLayerException {
        Optional<List<User>>  listOpt = this.userRepository.getByName(name);
        if (listOpt.isEmpty()) {
            throw new ServiceLayerException(ErrorMessages.ENTITY_NOT_FOUND);
        }
        return listOpt.get();
    }
}
