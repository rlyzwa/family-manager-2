package ch.avanchets.familymanager.repositories;

import ch.avanchets.familymanager.domain.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rafal Lyzwa on 23-Nov-16.
 */
@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {
    List<Currency> findAll();
}
