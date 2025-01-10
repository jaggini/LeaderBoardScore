package com.example.SpringbootLeaderBoardSCore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SpringbootLeaderBoardSCore.controller.UserController;
import com.example.SpringbootLeaderBoardSCore.entity.Badge;
import com.example.SpringbootLeaderBoardSCore.entity.User;
import com.example.SpringbootLeaderBoardSCore.serviece.UserServieceImple;

@SpringBootTest
class SpringbootLeaderBoardSCoreApplicationTests {

    @Autowired
    private UserController userController;

    // @BeforeEach
    // public void setUp() {
    //     UserServieceImple userServiece = new UserServieceImple();

    //     userController = new UserController(userServiece);

    // }


    @Test
    public void testCreateUser() {
        
        User u = new User(0, "1", "Dinga", new HashSet<>());
        User user = userController.newRegisterUser(u).getBody();
        assertNotNull(user);
        assertEquals("Dinga", user.getUsername());
        // assertEquals(0, user.getScore());
        // assertTrue(user.getBadges().isEmpty());

    }

    @Test
    public void testgetUserById() {
        User user = new User(50, "2", "Raju", new HashSet<>());
        userController.newRegisterUser(user);
        User u = userController.getAllDetails("1").getBody();
        assertNotNull(u);
        assertEquals("Dinga", u.getUsername());

    }

    @Test
    public void testSortingByScore() {
        User u = new User(0, "1", "Dinga", new HashSet<>());
        userController.newRegisterUser(u);
        User user = userController.updateScore("1", 50).getBody();
        assertNotNull(user);
        assertEquals(user.getScore(), 50);
    }

    @Test
    void testDeleteUser() {
        User u = new User(0, "1", "Dinga", new HashSet<>());
        userController.newRegisterUser(u);
        userController.deleteUsers("1");
        User delete = userController.getAllDetails("1").getBody();
        assertNull(delete);

    }

    @Test
    void contextLoads() {
    }

}
