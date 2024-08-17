package org.portevent.springpotager.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "farmer_chip")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FarmerChip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Chip chip;

    @ManyToOne(fetch = FetchType.LAZY)
    private Farmer farmer;
}