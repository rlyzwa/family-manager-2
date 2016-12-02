package ch.avanchets.familymanager.repositories.bank;

import ch.avanchets.familymanager.domain.bank.BankTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Rafal Lyzwa on 22-Nov-16.
 */
@Transactional
public interface BankTransactionsRepository extends CrudRepository<BankTransaction, Long> {
    BankTransaction save(BankTransaction bankTransaction);
    List<BankTransaction> findAll();
}
