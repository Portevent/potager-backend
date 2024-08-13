package org.portevent.springpotager.service;

import org.portevent.springpotager.dto.FarmerDTO;
import org.portevent.springpotager.dto.leekwars.FarmerPublicDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Service
public class LeekwarsService {

    private final RestClient restClient;

    public LeekwarsService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://leekwars.com/api").build();
    }

    public FarmerDTO getFarmer(String id) {
        return Objects.requireNonNull(
                this.restClient.get().uri("/farmer/get/{id}", id)
                        .retrieve().body(FarmerPublicDTO.class)
        ).getFarmer();
    }
//
//    public Leek getLeek(String id) {
//        return this.restClient.get().uri("/leek/get/{id}", id).retrieve().body(Details.class);
//    }
}
