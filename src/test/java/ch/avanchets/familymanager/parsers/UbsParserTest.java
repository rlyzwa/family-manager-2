package ch.avanchets.familymanager.parsers;

import ch.avanchets.familymanager.domain.bank.BankTransaction;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Rafal Lyzwa on 21-Nov-16.
 */
public class UbsParserTest {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("c:/Users/rafal/Downloads/export_ubs.csv ");
//        PostFinanceParser parser = new PostFinanceParser();
        UbsParser parser = new UbsParser();
        List<? extends BankTransaction> transactions = parser.parseTransactions(is);
        is.close();

        for (BankTransaction t : transactions) {
            System.out.println(t.getAccountingDate() + " : "  +
                    t.getValueDate() + " : " + t.getAmount() + " : " +
                    t.getReference() + " : " + t.getDescription());
        }
    }
}
