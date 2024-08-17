package org.portevent.springpotager.dto.account;

import lombok.Data;

@Data
public class AccountCreationDTO {
    private Long id;

    private String login;

    private String mail;

    private String password;
}
