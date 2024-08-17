package org.portevent.springpotager.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ai")
public class Ai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Integer level;

    @ManyToOne
    private AiFolder folder;

    private Boolean valid;

    private Integer version;

    private Integer total_lines;

    private Integer total_char;

    private Boolean entrypoint;

    @ManyToMany
    private List<Ai> entrypoints;

    private Integer scenario;

    @ManyToMany
    private List<Ai> includes;

}

