package org.portevent.springpotager.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Builder
@Entity
@Table(name = "farmer_weapon")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FarmerWeapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Weapon weapon;

    @ManyToOne(fetch = FetchType.LAZY)
    private Farmer farmer;
}