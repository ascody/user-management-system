package tabbychiro.userManagementSystem.service;

import org.springframework.web.bind.annotation.RequestParam;
import tabbychiro.userManagementSystem.dto.AuthTokenDto;
import tabbychiro.userManagementSystem.dto.UserResponseDto;
import tabbychiro.userManagementSystem.dto.UserLoginDto;
import tabbychiro.userManagementSystem.dto.UserRegisterDto;

public interface UserService {
    UserResponseDto register(UserRegisterDto dto);
    AuthTokenDto login(UserLoginDto dto);
    Boolean isEmailAvailable(String email);
    Boolean isUsernameAvailable(String username);
    Boolean isNicknameAvailable(String password);
}
