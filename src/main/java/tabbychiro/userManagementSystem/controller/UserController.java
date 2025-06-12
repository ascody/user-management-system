package tabbychiro.userManagementSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tabbychiro.userManagementSystem.dto.AuthTokenDto;
import tabbychiro.userManagementSystem.dto.ResponseDto;
import tabbychiro.userManagementSystem.dto.UserLoginDto;
import tabbychiro.userManagementSystem.dto.UserRegisterDto;
import tabbychiro.userManagementSystem.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody UserRegisterDto dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthTokenDto> login(@RequestBody UserLoginDto dto) {
        return ResponseEntity.ok(userService.login(dto));
    }
}
