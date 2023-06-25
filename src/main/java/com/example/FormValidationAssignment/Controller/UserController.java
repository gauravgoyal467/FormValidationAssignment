package com.example.FormValidationAssignment.Controller;

import com.example.FormValidationAssignment.Model.Login;
import com.example.FormValidationAssignment.Model.User;
import com.example.FormValidationAssignment.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) throws Exception {
        userService.signup(user);
        return new ResponseEntity<>("User signedUp Successfully !", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login loginRequest) throws Exception {
        String token= userService.login(loginRequest);
        return new ResponseEntity<>("logged in successfully! ,Token No : "+token, HttpStatus.OK);
    }
}
