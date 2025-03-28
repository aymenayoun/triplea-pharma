package com.ayouni.tripleA.Pharma.service.interf;

import com.ayouni.tripleA.Pharma.dto.LoginRequest;
import com.ayouni.tripleA.Pharma.dto.Response;
import com.ayouni.tripleA.Pharma.dto.UserDto;
import com.ayouni.tripleA.Pharma.entity.User;

public interface UserService {
    Response registerUser(UserDto registrationRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getLoginUser();
    Response getUserInfoAndOrderHistory();
}
