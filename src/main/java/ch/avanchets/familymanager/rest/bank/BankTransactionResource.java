package ch.avanchets.familymanager.rest.bank;

import ch.avanchets.familymanager.domain.bank.BankTransaction;
import ch.avanchets.familymanager.repositories.bank.BankTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rafal Lyzwa on 23-Nov-16.
 */
@RestController
@RequestMapping("/api/transactions/")
public class BankTransactionResource {

    private BankTransactionsRepository repository;

    @Autowired
    public BankTransactionResource(BankTransactionsRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BankTransaction> getAll() {

        return repository.findAll();
    }
}
