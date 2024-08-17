package org.portevent.springpotager.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "team")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer level;

    private Long emblem_changed;

    private Long chat;

    private Integer member_level;
}