package org.portevent.springpotager.dto.farmer;

import lombok.*;
import org.portevent.springpotager.dto.TeamDTO;
import org.portevent.springpotager.dto.leek.PublicLeekDto;

import java.util.List;
import java.util.Map;

@Data
public class PublicFarmerDto {

    protected Long id;

    protected String login;

    protected TeamDTO team;

    protected String name;

    protected Integer talent;

    protected Map<Long, PublicLeekDto> leeks;

    protected Long avatar_changed;

    protected Integer talent_more;

    protected Integer victories;

    protected Integer draws;

    protected Integer defeats;

    protected String ratio;

    protected Integer last_connection;

    protected Integer register_date;

    // TODO fight_history

    // TODO tournaments

    protected Boolean admin;

    protected Boolean moderator;

    protected String country;

    protected FarmerNameDto godfather;

    protected List<FarmerNameDto> godsons;

    protected String color;

    protected Boolean banned;

    protected Integer won_solo_tournaments;

    protected Integer won_farmer_tournaments;

    protected Integer won_team_tournaments;

    protected Integer won_battle_royale;

    protected Integer total_level;

    protected Integer leek_count;

    protected Boolean in_garden;

    protected Integer fights;

    protected Integer team_fights;

    protected String github;

    protected String website;

    protected Integer forum_messages;

    protected Boolean didactitiel_seen;

    protected Boolean contributor;

    protected Integer trophies;

    protected Integer points;

    protected String language;

    protected List<Integer> title;

    protected Boolean show_ai_lines;

    protected Integer ranking;

    protected Boolean verified;

    protected Integer tutorial_progress;

    protected String group;

    protected String supervised_group;

    protected Boolean bank_enabled;

    protected Boolean public_chat_enabled;

    protected Boolean buy_fights_enabled;

    protected Boolean tournaments_enabled;

    protected Boolean br_enabled;

    protected Boolean equipment_enabled;

    protected Boolean can_create_leek;

    protected Integer godsons_level;

    private Boolean pass;

    private Integer habs;

    private Integer crystals;
}