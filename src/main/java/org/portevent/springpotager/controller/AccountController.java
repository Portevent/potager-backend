package org.portevent.springpotager.controller;

import org.portevent.springpotager.dto.AccountCreationDTO;
import org.portevent.springpotager.dto.AccountDTO;
import org.portevent.springpotager.mapper.AccountMapper;
import org.portevent.springpotager.service.AccountService;
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
    private AccountMapper accountMapper;

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
}
