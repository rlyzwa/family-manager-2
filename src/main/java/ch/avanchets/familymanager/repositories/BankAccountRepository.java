package ch.avanchets.familymanager.repositories;

import ch.avanchets.familymanager.domain.bank.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rafal Lyzwa on 01-Dec-16.
 */
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    List<BankAccount> findAll();
}
