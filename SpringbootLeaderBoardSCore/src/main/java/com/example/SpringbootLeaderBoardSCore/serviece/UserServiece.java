package com.example.SpringbootLeaderBoardSCore.serviece;

import java.util.List;
import java.util.Optional;

import com.example.SpringbootLeaderBoardSCore.entity.User;

public interface UserServiece {

    public List<User> getAllUsersByScore();

    public User createUser(User u);

    public User updateUser(int score, String userId);

    public void deleteUser(User u);

    

    public Optional<User> getUserById(String userId);

}
