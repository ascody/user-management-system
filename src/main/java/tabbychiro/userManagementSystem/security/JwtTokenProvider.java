package tabbychiro.userManagementSystem.security;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration-in-ms}")
    private long validityInMillSeconds;

}
