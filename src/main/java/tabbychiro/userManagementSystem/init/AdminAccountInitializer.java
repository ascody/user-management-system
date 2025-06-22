package tabbychiro.userManagementSystem.init;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tabbychiro.userManagementSystem.entity.User;
import tabbychiro.userManagementSystem.enums.Role;
import tabbychiro.userManagementSystem.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class AdminAccountInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        String adminUsername = "admin";
        String adminPassword = "1234";
        String adminEmail = "nvm7588@gmail.com";
        String adminNickname = "admin";

        if (!userRepository.existsByUsername(adminUsername)) {
            User admin = User.builder()
                    .username(adminUsername)
                    .password(passwordEncoder.encode(adminPassword))
                    .nickname(adminNickname)
                    .email(adminEmail)
                    .enabled(true)
                    .locked(false)
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(admin);
            System.out.println("관리자 계정 생성 완료! (username: admin)");
        } else {
            System.out.println("이미 관리자 계정이 존재합니다.");
        }
    }
}
