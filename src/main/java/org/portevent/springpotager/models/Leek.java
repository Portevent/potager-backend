package org.portevent.springpotager.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "leek")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Leek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer level;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;
}