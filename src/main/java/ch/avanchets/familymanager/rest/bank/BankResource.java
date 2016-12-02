package ch.avanchets.familymanager.rest.bank;

import ch.avanchets.familymanager.domain.bank.Bank;
import ch.avanchets.familymanager.repositories.BankRepository;

import java.util.List;

/**
 * Created by Rafal Lyzwa on 14-Nov-16.
 */

public class BankResource {


    private BankRepository bankRepository;

    public BankResource(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getAll() {

        return null;
    }

    public void add() {

    }
}
