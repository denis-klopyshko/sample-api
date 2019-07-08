package com.sample.api.controller;

import com.sample.api.dto.User;
import com.sample.api.exception.EntityNotFoundException;
import com.sample.api.repository.UserRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    private UserRespository userRespository;

    @Autowired
    public UserController(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@Valid @PathVariable final Long id) {
        log.info("Getting user with id = {}", id);
        User user = userRespository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody final User user) {
        log.info("Creating User : {}", user);
        User savedUser = userRespository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        log.info("Getting users list");
        List<User> usersList = (List<User>) userRespository.findAll();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        log.info("Fetching & Deleting User with id {}", id);
        User user = userRespository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        userRespository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
