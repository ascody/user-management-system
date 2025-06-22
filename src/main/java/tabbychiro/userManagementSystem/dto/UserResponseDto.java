package tabbychiro.userManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import tabbychiro.userManagementSystem.entity.User;

@Getter
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String username;
    private String nickname;
    private String email;
    private String role;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.role = user.getRole().name();
    }
}