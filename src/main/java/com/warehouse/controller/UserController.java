package com.warehouse.controller;

import com.warehouse.Configuration.JWTToken;
import com.warehouse.model.User;
import com.warehouse.repository.UserRepo;
import com.warehouse.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserController {

    private final UserRepo userRepo;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTToken jwtToken;




    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = passwordEncoder.encode(body.get("password"));

        if(userRepo.findByEmail(email).isPresent()){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email already exist");
        }
        userService.createUser(User.builder().email(email).password(password).build());
        return ResponseEntity.ok("User Created");
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = body.get("password");

        Optional<User> optionalUser = userRepo.findByEmail(email);
        if(optionalUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not exist");
        }

        User user = optionalUser.get();

        if(!passwordEncoder.matches(password, user.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }

        String token = jwtToken.generateToken(email);
        return ResponseEntity.ok().body(token);
    }


}
