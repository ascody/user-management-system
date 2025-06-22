package tabbychiro.userManagementSystem.service;

import tabbychiro.userManagementSystem.dto.AuthTokenDto;
import tabbychiro.userManagementSystem.dto.UserResponseDto;
import tabbychiro.userManagementSystem.dto.UserLoginDto;
import tabbychiro.userManagementSystem.dto.UserRegisterDto;

public interface UserService {
    UserResponseDto register(UserRegisterDto dto);
    AuthTokenDto login(UserLoginDto dto);
}
