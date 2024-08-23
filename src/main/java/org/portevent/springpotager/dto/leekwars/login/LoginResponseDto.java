package org.portevent.springpotager.dto.leekwars.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.portevent.springpotager.dto.leekwars.LeekwarsFarmerDto;

@AllArgsConstructor
@Data
public class LoginResponseDto {
    private LeekwarsFarmerDto farmer;

    @JsonProperty("farmers")
    private Integer connectedFarmers;

    // TODO message

    // TODO notifications

    // TODO conversations

    // TODO chats
}
