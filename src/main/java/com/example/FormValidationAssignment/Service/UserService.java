package com.example.FormValidationAssignment.Service;

import com.example.FormValidationAssignment.Config.JwtToken;
import com.example.FormValidationAssignment.Exceptions.UserAlreadyExistsException;
import com.example.FormValidationAssignment.Exceptions.WrongCredentialException;
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
        public void signup(User user) throws Exception {
            if (userRepository.findByUsername(user.getUsername()) != null) {
                throw new UserAlreadyExistsException("Username already exists");
            }
            User currentUser = User.builder()
                    .username(user.getUsername())
                    .password(passwordEncoder.encode(user.getPassword()))
                    .build();
            userRepository.save(currentUser);
        }
        public String login(Login loginRequest) throws Exception {
            String username=loginRequest.getUsername();
            String password=loginRequest.getPassword();
            User fetchedUser = userRepository.findByUsername(username);
            if (fetchedUser == null || !passwordEncoder.matches(password, fetchedUser.getPassword())) {
                throw new WrongCredentialException("Wrong credentials used please enter correct one !");
            }
            return jwtToken.generateToken(fetchedUser.getUsername());
        }
    }