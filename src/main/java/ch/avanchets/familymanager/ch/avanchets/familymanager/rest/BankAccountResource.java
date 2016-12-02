package ch.avanchets.familymanager.ch.avanchets.familymanager.rest;

import ch.avanchets.familymanager.domain.bank.BankAccount;
import ch.avanchets.familymanager.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rafal Lyzwa on 01-Dec-16.
 */
@RestController
@RequestMapping("/api/accounts/")
public class BankAccountResource {

    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountResource(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping
    public List<BankAccount> all() {
        List<BankAccount> accounts = bankAccountRepository.findAll();
        return accounts;
    }
}
