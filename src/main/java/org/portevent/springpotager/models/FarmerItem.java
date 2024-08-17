package org.portevent.springpotager.models;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "farmer_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FarmerItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    private Farmer farmer;
}