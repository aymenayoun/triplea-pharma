package com.ayouni.tripleA.Pharma.controller;

import com.ayouni.tripleA.Pharma.dto.LoginRequest;
import com.ayouni.tripleA.Pharma.dto.Response;
import com.ayouni.tripleA.Pharma.dto.UserDto;
import com.ayouni.tripleA.Pharma.entity.User;
import com.ayouni.tripleA.Pharma.repository.UserRepo;
import com.ayouni.tripleA.Pharma.service.interf.UserService;

import org.slf4j.Logger;
import lombok.RequiredArgsConstructor;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody UserDto registrationRequest){
        System.out.println(registrationRequest);
        return ResponseEntity.ok(userService.registerUser(registrationRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }
}
    */
/*works on Postman-------- */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")//pass all origins 
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    private final UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody UserDto registrationRequest) {
        return ResponseEntity.ok(userService.registerUser(registrationRequest));
    }

    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email or user not found"));
    
        if (user.isVerified()) {
            return ResponseEntity.badRequest().body("User is already verified.");
        }
    
        user.setVerified(true);
        userRepo.save(user);
        return ResponseEntity.ok("User successfully verified!");
    }

    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody LoginRequest loginRequest) {
        log.info("Processing login request for user: {}", loginRequest.getEmail());
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }
    
    
}
/*--------------- */

/*loginworks here --------
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody UserDto registrationRequest){
        System.out.println(registrationRequest);
        return ResponseEntity.ok(userService.registerUser(registrationRequest));
    }
    @PostMapping("/login")
    public ResponseEntity<Response> loginUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }
}
    -----------*/