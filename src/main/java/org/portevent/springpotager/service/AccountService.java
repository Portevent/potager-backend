package org.portevent.springpotager.service;

import net.datafaker.Faker;
import org.portevent.springpotager.models.Account;
import org.portevent.springpotager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccount(final Long id) {
        return accountRepository.findById(id);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void deleteAccount(final Long id) {
        accountRepository.deleteById(id);
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getFakeAccount() {
        Faker faker = new Faker();
        return Account.builder()
                .name(faker.name().firstName())
                .mail(faker.internet().emailAddress())
                .password(faker.bothify("???????"))
                .build();
    }

}
