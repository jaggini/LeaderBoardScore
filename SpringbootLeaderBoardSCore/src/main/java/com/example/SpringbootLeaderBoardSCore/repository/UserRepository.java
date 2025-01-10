package com.example.SpringbootLeaderBoardSCore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.SpringbootLeaderBoardSCore.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

}
