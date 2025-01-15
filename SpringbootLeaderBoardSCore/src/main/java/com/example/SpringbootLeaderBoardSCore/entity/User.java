package com.example.SpringbootLeaderBoardSCore.entity;

// import java.util.HashSet;
import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "users")
public class User {

    @NotNull

    @Id
    private String userId;
    @NotBlank(message = "Username not blank")
    private String username;
    @Min(value = 0)
    @Max(value = 100)
    private int score; 
    private List<String>  badges = new ArrayList<>();

    public User(int score, String userId, String username, List<String> badges) {
        this.score = score;
        this.userId = userId;
        this.username = username;
        this.badges = badges;

    }

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
  

    
    public  List<String> getBadges() {
        return badges;
    }
 
         
    public void setBadges( List<String> badges) {
        this.badges = badges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", score=").append(score);
        sb.append(", badges=").append(badges);
        sb.append('}');
        return sb.toString();
    }

    // public void setUserName(String dinga) {
    // }
}
