package tabbychiro.userManagementSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tabbychiro.userManagementSystem.dto.AuthTokenDto;
import tabbychiro.userManagementSystem.dto.UserResponseDto;
import tabbychiro.userManagementSystem.dto.UserLoginDto;
import tabbychiro.userManagementSystem.dto.UserRegisterDto;
import tabbychiro.userManagementSystem.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRegisterDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthTokenDto> login(@RequestBody UserLoginDto dto) {
        return ResponseEntity.ok(userService.login(dto));
    }
}
