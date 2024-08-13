package org.portevent.springpotager.dto;

import lombok.Data;

@Data
public class AccountCreationDTO {
    private Long id;

    private String name;

    private String mail;

    private String password;
}
