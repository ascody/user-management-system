package tabbychiro.userManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;

@Entity
public class LoginHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private LocalDateTime loginTime;
    private String ipAddress;
    private String userAgent;
    private boolean success;

    @Builder
    public LoginHistory(User user, LocalDateTime loginTime, String ipAddress, String userAgent, boolean success) {
        this.user = user;
        this.loginTime = loginTime;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.success = success;
    }

    public LoginHistory() {}
}
