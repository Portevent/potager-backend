package org.portevent.springpotager.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Builder
@Entity
@Table(name = "farmer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Farmer {

    @Id
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "farmer", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Leek> leeks;

    private String login;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @OneToMany
    private List<FarmerWeapon> weapons;

    @OneToMany
    private List<FarmerChip> chips;

    @OneToMany
    private List<FarmerItem> items;

    @OneToMany
    private List<Ai> ais;

    @OneToMany
    private List<AiFolder> folders;

    private String name;

    private Integer talent;

    private Long avatar_changed;

    private Integer talent_more;

    private Integer victories;

    private Integer draws;

    private Integer defeats;

    private Integer last_connection;

    private Integer register_date;

    private Boolean admin;

    private Boolean moderator;

    private String country;

    private Long godfather_id;

    // private List<Farmer> godsons_id;

    private String color;

    private Boolean banned;

    private Integer won_solo_tournaments;

    private Integer won_farmer_tournaments;

    private Integer won_team_tournaments;

    private Integer won_battle_royale;

    private Boolean in_garden;

    private Integer fights;

    private Integer team_fights;

    private String github;

    private String website;

    private Integer forum_messages;

    private Boolean didactitiel_seen;

    private Boolean contributor;

    private Integer trophies;

    private Integer points;

    private String language;

    // private List<Title> title;

    private Boolean show_ai_lines;

    private Integer ranking;

    private Boolean verified;

    private Integer tutorial_progress;

    @Column(name = "_group")
    private String group;

    private String supervised_group;

    private Boolean bank_enabled;

    private Boolean public_chat_enabled;

    private Boolean buy_fights_enabled;

    private Boolean tournaments_enabled;

    private Boolean br_enabled;

    private Boolean equipment_enabled;

    private Boolean can_create_leek;

    private Integer godsons_level;

    private Boolean pass;

    private Integer habs;

    private Integer crystals;

    private Boolean tournament_registered;

    private Integer tournament_current;

    private String candidacy;
}