package com.practices.msvc.user.controller;

import com.practices.msvc.user.models.entity.User;
import com.practices.msvc.user.exception.ServiceLayerException;
import com.practices.msvc.user.models.dto.UserDto;
import com.practices.msvc.user.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Object> getAll(){
        try {
            List<User> userList = this.userService.getAll();
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (ServiceLayerException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/user", produces = "application/json")
    public ResponseEntity<Object> getByEmail(@RequestParam String email){
        try {
            User user = this.userService.getByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ServiceLayerException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/user", produces = "application/json")
    public ResponseEntity<Object> getByIdNumber(@RequestParam(name = "id") Long idNumber){
        try {
            User user = this.userService.getByIdNumber(idNumber);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ServiceLayerException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/user/{name}", produces = "application/json")
    public ResponseEntity<Object> getByName(@PathVariable String name){
        try {
            List<User> userList = this.userService.getByName(name);
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (ServiceLayerException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto){
        try {
            User newUser = new User(userDto.getIdNumber(), userDto.getName(), userDto.getLastName(), userDto.getEmail(), "123456",userDto.getBirthday());
            this.userService.save(newUser);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ServiceLayerException e) {
            LOGGER.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
