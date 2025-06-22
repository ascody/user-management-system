package tabbychiro.userManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class RefreshToken {
    @Id
    private String token;

    @OneToOne
    private User user;

    private LocalDateTime expiryTime;
}
