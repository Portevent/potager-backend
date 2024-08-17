package org.portevent.springpotager.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Builder
@Entity
@Table(name = "leek")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Leek {

    @Id
    private Long id;

    private String name;

    private Integer level;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Farmer farmer;

    private Integer talent;

    private Integer talentMore;

    private Integer xp;

    private Integer up_xp;

    private Integer victories;

    private Integer draws;

    private Integer defeats;

    private Integer maxWeapons;

    @ManyToMany
    private List<Weapon> weapons;

    private Integer maxChips;

    @ManyToMany
    private List<Chip> chips;

    @ManyToOne(fetch = FetchType.LAZY)
    @Nullable
    @JoinColumn(name="ai_id", nullable=true)
    private Ai ai;

    // TODO : Fights

    private Integer skin;

    @ManyToOne
    private Hat hat;

    @ManyToOne
    private Weapon displayedWeapon;

    @ManyToMany
    private List<Title> titles;

    private Integer ranking;

    private Boolean metal;

    private Boolean xpBlocked;

    private Integer face;

    @ManyToMany
    private List<Component> components;

    private Integer life;

    private Integer strength;

    private Integer wisdom;

    private Integer agility;

    private Integer resistance;

    private Integer science;

    private Integer magic;

    private Integer frequency;

    private Integer cores;

    private Integer ram;

    private Integer tp;

    private Integer mp;

    private Integer totalLife;

    private Integer totalStrength;

    private Integer totalWisdom;

    private Integer totalAgility;

    private Integer totalResistance;

    private Integer totalScience;

    private Integer totalMagic;

    private Integer totalFrequency;

    private Integer totalCores;

    private Integer totalRam;

    private Integer totalTp;

    private Integer totalMp;

    private Integer capital;

    private Integer levelSeen; // Unknown use, returned by Leekwars, so far is identical to level

    private Boolean autoBattleRoyal;
}