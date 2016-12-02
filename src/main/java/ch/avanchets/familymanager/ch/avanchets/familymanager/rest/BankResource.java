package ch.avanchets.familymanager.ch.avanchets.familymanager.rest;

import ch.avanchets.familymanager.domain.bank.Bank;
import ch.avanchets.familymanager.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rafal Lyzwa on 01-Dec-16.
 */
@RestController
@RequestMapping("/api/banks/")
public class BankResource {

    private BankRepository bankRepository;

    @Autowired
    public BankResource(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @GetMapping
    public List<Bank> all() {
        List<Bank> banks
                = bankRepository.findAll();
        return banks;
    }
}
