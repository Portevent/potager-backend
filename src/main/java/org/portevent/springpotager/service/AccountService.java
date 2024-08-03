package org.portevent.springpotager.service;

import lombok.Data;
import org.portevent.springpotager.models.Account;
import org.portevent.springpotager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccount(final Long id) {
        return accountRepository.findById(id);
    }

    public Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void deleteAccount(final Long id) {
        accountRepository.deleteById(id);
    }

    public Account saveAccount(Account Account) {
        Account savedAccount = accountRepository.save(Account);
        return savedAccount;
    }

}
