package tabbychiro.userManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterDto {
    private String email;
    private String username;
    private String password;
    private String nickname;
}
