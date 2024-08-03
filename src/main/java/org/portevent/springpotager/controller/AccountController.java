package org.portevent.springpotager.controller;

import org.portevent.springpotager.models.Account;
import org.portevent.springpotager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public Iterable<Account> getAccounts() {
        return accountService.getAccounts();
    }
    

    @PostMapping
    Account newAccount(@RequestBody Account newAccount) {
        return accountService.saveAccount(newAccount);
    }

    // Single item

    @GetMapping("/{id}")
    Account get(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow();
    }

    @PutMapping("/{id}")
    Account replaceAccount(@RequestBody Account newAccount, @PathVariable Long id) {
        newAccount.setId(id);
        return accountService.saveAccount(newAccount);
    }

    @DeleteMapping("/{id}")
    void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
