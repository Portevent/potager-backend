package org.portevent.springpotager.dto.leekwars.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class LoginRequestDto {
    private boolean keep_connected;
    private String login;
    private String password;
}
