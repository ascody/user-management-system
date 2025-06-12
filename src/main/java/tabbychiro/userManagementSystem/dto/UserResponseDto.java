package tabbychiro.userManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String username;
    private String nickname;
}