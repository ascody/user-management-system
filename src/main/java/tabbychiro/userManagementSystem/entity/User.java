package tabbychiro.userManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import tabbychiro.userManagementSystem.enums.Role;

import java.time.LocalDateTime;

@Getter
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(unique = true, nullable = false)
    private String email;

    private boolean enabled;
    private boolean locked;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;

    @Builder
    public User(String username, String password, String nickname, String email, boolean enabled, boolean locked, Role role) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.enabled = enabled;
        this.locked = locked;
        this.role = role;
    }

    protected User() {}
}
