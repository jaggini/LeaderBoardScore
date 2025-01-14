package com.example.SpringbootLeaderBoardSCore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringbootLeaderBoardSCore.entity.User;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
    
  //  User deleteUser(String userId);
}
