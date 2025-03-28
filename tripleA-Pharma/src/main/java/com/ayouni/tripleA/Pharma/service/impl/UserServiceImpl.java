package com.ayouni.tripleA.Pharma.service.impl;

import com.ayouni.tripleA.Pharma.dto.LoginRequest;
import com.ayouni.tripleA.Pharma.dto.Response;
import com.ayouni.tripleA.Pharma.dto.UserDto;
import com.ayouni.tripleA.Pharma.entity.User;
import com.ayouni.tripleA.Pharma.enums.UserRole;
import com.ayouni.tripleA.Pharma.exception.InvalidCredentialsException;
import com.ayouni.tripleA.Pharma.exception.NotFoundException;
import com.ayouni.tripleA.Pharma.mapper.EntityDtoMapper;
import com.ayouni.tripleA.Pharma.repository.UserRepo;
import com.ayouni.tripleA.Pharma.security.JwtUtils;
import com.ayouni.tripleA.Pharma.service.MailService;
import com.ayouni.tripleA.Pharma.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final EntityDtoMapper entityDtoMapper;
    private final MailService mailService;


    /*@Override
    public Response registerUser(UserDto registrationRequest) {
        UserRole role = UserRole.USER;

        if (registrationRequest.getRole() != null && registrationRequest.getRole().equalsIgnoreCase("admin")) {
            role = UserRole.ADMIN;
        }

        User user = User.builder()
                .name(registrationRequest.getName())
                .email(registrationRequest.getEmail())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .phoneNumber(registrationRequest.getPhoneNumber())
                .role(role)
                .build();

        User savedUser = userRepo.save(user);
        System.out.println(savedUser);

        UserDto userDto = entityDtoMapper.mapUserToDtoBasic(savedUser);
        return Response.builder()
                .status(200)
                .message("User Successfully Added")
                .user(userDto)
                .build();
    }*/
    @Override
    public Response registerUser(UserDto registrationRequest) {
        try {
            log.info("Attempting to register user with email: {}", registrationRequest.getEmail());
    
            UserRole role = UserRole.USER;
    
            if (registrationRequest.getRole() != null && registrationRequest.getRole().equalsIgnoreCase("admin")) {
                role = UserRole.ADMIN;
            }
    
            User user = User.builder()
                    .name(registrationRequest.getName())
                    .email(registrationRequest.getEmail())
                    .password(passwordEncoder.encode(registrationRequest.getPassword()))
                    .phoneNumber(registrationRequest.getPhoneNumber())
                    .role(role)
                    .isVerified(false)
                    .build();
    
            User savedUser = userRepo.save(user);
            log.info("User saved successfully: {}", savedUser);
    
            String verificationLink = "http://localhost:2424/api/auth/verify?email=" + savedUser.getEmail();
            mailService.sendVerificationEmail(savedUser.getEmail(), verificationLink);
    
            UserDto userDto = entityDtoMapper.mapUserToDtoBasic(savedUser);
            return Response.builder()
                    .status(200)
                    .message("User registered successfully. Please check your email to verify your account.")
                    .user(userDto)
                    .build();
        } catch (Exception e) {
            log.error("Error during user registration: ", e);
            throw new RuntimeException("Registration failed due to an internal error.");
        }
    }
    
    




    @Override
    public Response loginUser(LoginRequest loginRequest) {

        User user = userRepo.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new NotFoundException("Email not found"));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())){
            throw new InvalidCredentialsException("Password does not match");
        }
        String token = jwtUtils.generateToken(user);

        return Response.builder()
                .status(200)
                .message("User Successfully Logged In")
                .token(token)
                .expirationTime("6 Month")
                .role(user.getRole().name())
                .build();
    }

    @Override
    public Response getAllUsers() {

        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream()
                .map(entityDtoMapper::mapUserToDtoBasic)
                .toList();

        return Response.builder()
                .status(200)
                .userList(userDtos)
                .build();
    }

    @Override
    public User getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String  email = authentication.getName();
        log.info("User Email is: " + email);
        return userRepo.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("User Not found"));
    }

    @Override
    public Response getUserInfoAndOrderHistory() {
        User user = getLoginUser();
        UserDto userDto = entityDtoMapper.mapUserToDtoPlusAddressAndOrderHistory(user);

        return Response.builder()
                .status(200)
                .user(userDto)
                .build();
    }
}
