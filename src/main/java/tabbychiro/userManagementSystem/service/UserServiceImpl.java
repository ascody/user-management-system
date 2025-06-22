package tabbychiro.userManagementSystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tabbychiro.userManagementSystem.dto.AuthTokenDto;
import tabbychiro.userManagementSystem.dto.UserLoginDto;
import tabbychiro.userManagementSystem.dto.UserRegisterDto;
import tabbychiro.userManagementSystem.dto.UserResponseDto;
import tabbychiro.userManagementSystem.entity.User;
import tabbychiro.userManagementSystem.enums.Role;
import tabbychiro.userManagementSystem.repository.UserRepository;
import tabbychiro.userManagementSystem.security.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthTokenDto login(UserLoginDto dto) {
        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("Username not found")
        );

        System.out.println("dto.getUsername() = " + dto.getUsername());
        System.out.println("user.getUsername() = " + user.getUsername());
        
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRole());

        return new AuthTokenDto(token);
    }

    public UserResponseDto register(UserRegisterDto dto) {
        if (userRepository.existsByUsername(dto.getUsername())) {
            throw new IllegalArgumentException("Username is already in use");
        }

        User user = User.builder()
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .nickname(dto.getNickname())
                .email(dto.getEmail())
                .enabled(true)
                .locked(false)
                .role(Role.USER)
                .build();

        User saved = userRepository.save(user);

        return new UserResponseDto(saved);
    }
}
