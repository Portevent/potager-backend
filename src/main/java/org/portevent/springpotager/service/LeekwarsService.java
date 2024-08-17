package org.portevent.springpotager.service;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;
import org.portevent.springpotager.dto.farmer.PublicFarmerDto;
import org.portevent.springpotager.dto.leekwars.getFarmerRequestDto;
import org.portevent.springpotager.dto.leekwars.login.LoginRequestDto;
import org.portevent.springpotager.dto.leekwars.login.LoginResponseDto;
import org.portevent.springpotager.dto.leekwars.spendCapital.SpendCapitalRequestArray;
import org.portevent.springpotager.dto.leekwars.spendCapital.SpendCapitalRequestDto;
import org.portevent.springpotager.mapper.FarmerMapper;
import org.portevent.springpotager.mapper.TokenMapper;
import org.portevent.springpotager.models.Account;
import org.portevent.springpotager.models.Leek;
import org.portevent.springpotager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Service
public class LeekwarsService {

    @Autowired
    private TokenMapper tokenMapper;

    private final RestClient restClient;

    private static final Logger LOG
            = LoggerFactory.getLogger(LeekwarsService.class);
    @Autowired
    private AccountRepository accountRepository;

    public LeekwarsService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl("https://leekwars.com/api").build();
    }

    // FIXME
    public PublicFarmerDto getFarmer(String id) {
        return Objects.requireNonNull(
                this.restClient.get().uri("/farmer/get/{id}", id)
                        .retrieve().body(getFarmerRequestDto.class)
        ).getFarmer();
    }

    public PublicFarmerDto login(Account account) {
        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .keep_connected(true)
                .login(account.getLogin())
                .password(account.getPassword())
                .build();
        ResponseEntity<LoginResponseDto> result = this.restClient
                        .post()
                        .uri("/farmer/login")
                        .body(loginRequestDto)
                        .retrieve()

                .toEntity(LoginResponseDto.class);

        String token = Objects.requireNonNull(result.getHeaders().get("Set-Cookie")).stream().filter(header -> header.contains("token=") && !header.contains("token=deleted;")).toList().getFirst();

        LOG.info("Raw token {}", token);

        account.setToken(tokenMapper.fromString(token));

        LOG.info("Got account {}", account);

        accountRepository.save(account);

        LOG.info("Saved account {}", account);

        return Objects.requireNonNull(result.getBody()).getFarmer();
    }

    public Boolean spendCapital(Leek leek, SpendCapitalRequestArray characteristics) {
        this.restClient
                .post()
                .uri("/leek/spend-capital")
                .body(
                        SpendCapitalRequestDto.builder()
                                .leek_id(leek.getId())
                                .characteristics(characteristics.toString())
                                .build()
                )
                .retrieve();
        return true;
    }
//
//    public Leek getLeek(String id) {
//        return this.restClient.get().uri("/leek/get/{id}", id).retrieve().body(Details.class);
//    }
}
