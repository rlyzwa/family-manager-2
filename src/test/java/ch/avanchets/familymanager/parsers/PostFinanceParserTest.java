package ch.avanchets.familymanager.parsers;

import ch.avanchets.familymanager.domain.bank.BankTransaction;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Rafal Lyzwa on 16-Nov-16.
 */
public class PostFinanceParserTest {

    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("c:/Users/rafal/Downloads/export_Mouvements_20160317-1.csv ");
        PostFinanceParser parser = new PostFinanceParser();
        List<BankTransaction> transactions = parser.parseTransactions(is);
        is.close();

        for (BankTransaction t : transactions) {
            System.out.println(t.getAccountingDate() + " : "  +
              t.getValueDate() + " : " + t.getAmount() + " : " + t.getDescription());
        }
    }
}
