package ch.avanchets.familymanager.repositories;

import ch.avanchets.familymanager.domain.bank.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rafal Lyzwa on 14-Nov-16.
 */
@Repository
public interface BankRepository extends CrudRepository<Bank, Long> {
    List<Bank> findAll();
}
