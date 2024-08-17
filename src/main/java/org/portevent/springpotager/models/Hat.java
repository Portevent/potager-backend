package org.portevent.springpotager.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "hat")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer template;

    private Integer hat_template;

    private Integer quantity;
}