package com.rasa.controllers;
import com.rasa.dto.CreateUserDTO;
import com.rasa.dto.RasaResponse;
import com.rasa.dto.UserDTO;
import com.rasa.entity.User;
import com.rasa.interfaces.UserService;
import com.rasa.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController{

    private final UserService userService;

    // Constructor Injection: Ensures the service is never null
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show_users")
    public ResponseEntity<List<UserDTO>> showUsers(){;

        return new ResponseEntity<>(userService.showAllUsers(), HttpStatus.OK);

    }

    @PostMapping("/insert_user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserDTO user){

        String ss = userService.insertUser(user);
        return new ResponseEntity<>(ss, HttpStatus.CREATED);
    }
}
