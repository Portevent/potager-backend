package org.portevent.springpotager.dto;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
public class FarmerDTO {

    private Long id;

    private String login;

    private TeamDTO team;

    private String name;

    private Integer talent;

    private Integer talent_more;

    private Integer victories;

    private Integer draws;

    private Integer defeats;

    private Map<Long, LeekDTO> leeks;

    private String ratio;

    private Integer last_connection;

    private Integer register_date;

    private Boolean admin;

    private Boolean moderator;

    private String country;

    private Long godfather_id;

    private List<Long> godsons_id;

    private String color;

    private Boolean banned;

    private Integer won_solo_tournaments;

    private Integer won_farmer_tournaments;

    private Integer won_team_tournaments;

    private Integer won_battle_royale;

    private Integer total_level;

    private Integer leek_count;

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

    private List<Integer> title;

    private Boolean show_ai_lines;

    private Integer ranking;

    private Boolean verified;

    private Integer tutorial_progress;

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