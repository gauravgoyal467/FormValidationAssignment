package com.example.FormValidationAssignment.Service;

import com.example.FormValidationAssignment.Config.JwtToken;
import com.example.FormValidationAssignment.Model.Login;
import com.example.FormValidationAssignment.Model.User;
import com.example.FormValidationAssignment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtToken jwtToken;
    public User signup(User user) {
        User currentUser=new User();
        currentUser.setUserId(user.getUserId());
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepository.save(currentUser);
    }

    public String login(Login loginRequest) {
       String username=loginRequest.getUserName();
        String password=loginRequest.getPassword();
        User fetchedUser = userRepository.findByUsername(username);
        if (fetchedUser == null || !passwordEncoder.matches(password, fetchedUser.getPassword())) {
           return "Invalid username or password";
        }
       return jwtToken.generateToken(String.valueOf(fetchedUser));
    }
}