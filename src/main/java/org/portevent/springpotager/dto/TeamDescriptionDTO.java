package org.portevent.springpotager.dto;

import lombok.Data;

@Data
public class TeamDescriptionDTO {

    private Long id;

    private String name;

    private Integer level;

    private Long emblem_changed;

    private Long chat;

    private Integer member_level;
}