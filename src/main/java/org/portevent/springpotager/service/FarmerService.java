package org.portevent.springpotager.service;

import net.datafaker.Faker;
import org.portevent.springpotager.models.Farmer;
import org.portevent.springpotager.models.Leek;
import org.portevent.springpotager.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public Optional<Farmer> getFarmer(final Long id) {
        return farmerRepository.findById(id);
    }

    public List<Farmer> getFarmers() {
        return farmerRepository.findAll();
    }

    public void deleteFarmer(final Long id) {
        farmerRepository.deleteById(id);
    }

    public Farmer saveFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public Farmer getFakeFarmer() {
        Faker faker = new Faker();
        Farmer.FarmerBuilder farmer = Farmer.builder()
                .login(faker.bothify("???????"));

        if(faker.number().numberBetween(1, 100) < 20){
            farmer.godfather_id((long) faker.number().numberBetween(1, 20));
        }

        if(faker.number().numberBetween(1, 100) < 20){
            farmer.github(faker.letterify("??????"));
        }

        if(faker.number().numberBetween(1, 100) < 20){
            farmer.github(faker.internet().webdomain());
        }


        int leek_count = faker.number().numberBetween(1,3);
        List<Leek> leeks = new ArrayList<>();
        for (int i = 0; i < leek_count; i++){
            leeks.add(Leek.builder().name(faker.funnyName().name()).build());
        }

        farmer.name(faker.name().firstName())
                .leeks(leeks)
                .talent(faker.number().numberBetween(1, 1000))
                .talent_more(faker.number().numberBetween(-200, 500))
                .victories(faker.number().numberBetween(1, 500))
                .draws(faker.number().numberBetween(1, 500))
                .defeats(faker.number().numberBetween(1, 500))
                .register_date(faker.number().numberBetween(100000, 500000))
                .last_connection(faker.number().numberBetween(100000, 500000))
                .admin(faker.bool().bool())
                .moderator(faker.bool().bool())
                .banned(faker.bool().bool())
                .color(faker.color().hex())
                .won_solo_tournaments(faker.number().numberBetween(1, 20))
                .won_farmer_tournaments(faker.number().numberBetween(1, 20))
                .won_team_tournaments(faker.number().numberBetween(1, 20))
                .won_battle_royale(faker.number().numberBetween(1, 20))
                .in_garden(faker.bool().bool())
                .fights(faker.number().numberBetween(0, 400))
                .team_fights(faker.number().numberBetween(0, 20))
                .forum_messages(faker.number().numberBetween(0, 20))
                .didactitiel_seen(faker.bool().bool())
                .contributor(faker.bool().bool())
                .trophies(faker.number().numberBetween(0, 50))
                .points(faker.number().numberBetween(0, 2000))
                .language(faker.letterify("??"))
                .show_ai_lines(faker.bool().bool())
                .ranking(faker.number().numberBetween(0, 50))
                .verified(faker.bool().bool())
                .tutorial_progress(faker.number().numberBetween(0, 50))
                .country(faker.letterify("??"))
                .group(faker.letterify("??"))
                .supervised_group(faker.letterify("??"))
                .bank_enabled(faker.bool().bool())
                .public_chat_enabled(faker.bool().bool())
                .buy_fights_enabled(faker.bool().bool())
                .tournaments_enabled(faker.bool().bool())
                .br_enabled(faker.bool().bool())
                .equipment_enabled(faker.bool().bool())
                .can_create_leek(leek_count < 3 && faker.bool().bool())
                .godsons_level(faker.number().numberBetween(0, 50))
                .pass(faker.bool().bool())
                .habs(faker.number().numberBetween(0, 50000000))
                .crystals(faker.number().numberBetween(0, 50))
                .tournament_registered(faker.bool().bool())
                .tournament_current(faker.number().numberBetween(0, 50))
                .candidacy(faker.letterify("??"));


        Farmer farmerEntity = farmer.build();
        leeks.forEach(leek -> leek.setFarmer(farmerEntity));
        return farmerEntity;
    }

}
