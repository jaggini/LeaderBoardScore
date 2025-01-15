package com.example.SpringbootLeaderBoardSCore.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringbootLeaderBoardSCore.entity.User;
import com.example.SpringbootLeaderBoardSCore.serviece.UserServieceImple;

import jakarta.validation.Valid;

@RestController

@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserServieceImple userServiece;

    public UserController(UserServieceImple userServiece) {
        this.userServiece = userServiece;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getRegisterUsers() {
        return ResponseEntity.ok(userServiece.getAllUsersByScore());

    }

    @PostMapping()
    public ResponseEntity<User> newRegisterUser(@Valid @RequestBody User u) {

        User register = userServiece.createUser(u);
        return ResponseEntity.ok(register);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getAllDetails(@PathVariable String userId) {

        Optional<User> u = userServiece.getUserById(userId);
        if (u.isPresent()) {
            return ResponseEntity.ok(u.get());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateScore(@PathVariable String userId, @PathVariable int score) {
        User u = userServiece.updateUser(score, userId);
        if (u != null) {
            return ResponseEntity.ok(u);
        }
        return new ResponseEntity<>(u, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUsers(@RequestBody User u) {
        userServiece.deleteUser(u);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
