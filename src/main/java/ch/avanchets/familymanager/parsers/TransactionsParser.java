package ch.avanchets.familymanager.parsers;

import ch.avanchets.familymanager.domain.bank.BankTransaction;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Rafal Lyzwa on 15-Nov-16.
 */
public interface TransactionsParser<T extends BankTransaction> {
    List<T> parseTransactions(InputStream inputStream);
}
