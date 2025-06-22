package tabbychiro.userManagementSystem.entity;

import jakarta.persistence.*;

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
}
