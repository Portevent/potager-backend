package org.portevent.springpotager.controller;

import org.portevent.springpotager.dto.account.AccountCreationDTO;
import org.portevent.springpotager.dto.account.AccountDTO;
import org.portevent.springpotager.dto.leekwars.LeekwarsFarmerDto;
import org.portevent.springpotager.mapper.AccountMapper;
import org.portevent.springpotager.mapper.FarmerMapper;
import org.portevent.springpotager.mapper.LeekwarsFarmerMapper;
import org.portevent.springpotager.models.Farmer;
import org.portevent.springpotager.service.AccountService;
import org.portevent.springpotager.service.FarmerService;
import org.portevent.springpotager.service.LeekwarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private LeekwarsService leekwarsService;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private LeekwarsFarmerMapper leekwarsFarmerMapper;
    
    @Autowired
    private FarmerService farmerService;

    @GetMapping
    public List<AccountDTO> getAccounts() {
        return accountMapper.toDTOs(accountService.getAccounts());
    }


    @PostMapping
    AccountDTO newAccount(@RequestBody AccountCreationDTO newAccount) {
        return accountMapper.toDTO(accountService.saveAccount(accountMapper.toCreationEntity(newAccount)));
    }


    @GetMapping("/fake")
    AccountDTO addFake() {
        return accountMapper.toDTO(accountService.saveAccount(accountService.getFakeAccount()));
    }


    @GetMapping("/count")
    Long getCount() {
        return accountService.getAccounts().spliterator().getExactSizeIfKnown();
    }


    @GetMapping("/{id}")
    AccountDTO get(@PathVariable Long id) {
        return accountMapper.toDTO(accountService.getAccount(id).orElseThrow());
    }


    @DeleteMapping("/{id}")
    void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @GetMapping("/login/{id}")
    Farmer login(@PathVariable Long id) {
        LeekwarsFarmerDto farmerDto = leekwarsService.login(accountService.getAccount(id).orElseThrow());

        Farmer farmer = leekwarsFarmerMapper.toEntity(farmerDto);

        return farmerService.saveFarmer(farmer);
    }
}
