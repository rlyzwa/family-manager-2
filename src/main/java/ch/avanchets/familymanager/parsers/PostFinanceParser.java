package ch.avanchets.familymanager.parsers;

import ch.avanchets.familymanager.domain.bank.BankTransaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal Lyzwa on 14-Nov-16.
 */
public class PostFinanceParser implements TransactionsParser<BankTransaction> {
    @Override
    public List<BankTransaction> parseTransactions(InputStream inputStream) {

        List<BankTransaction> transactions = new ArrayList<>();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line = br.readLine();
            if (line.startsWith("Date du")) {

                String dateAsString = line.split(";")[1];
                line = br.readLine();

                if (line.startsWith("Date au")) {
                    dateAsString = line.split(";")[1];
                }

                line = br.readLine();
            }
            br.readLine();
            line = br.readLine();
            String iban = line.split(";")[1];
            String ccy = line.split(";")[1];
            String[] headers = br.readLine().split(";");

            while ((line = br.readLine()) != null) {
                if (!"".equals(line)) {
                    BankTransaction transaction = new BankTransaction();
                    //transaction.setCcy(ccy);
                    String[] fields = line.split(";");
                    transaction.setAccountingDate(LocalDate.parse(fields[0], formatter));
                    transaction.setDescription(fields[1]);
                    if (fields[2] != null && !"".equals(fields[2])) {
                        BigDecimal credit = new BigDecimal(fields[2].replaceAll("'", ""));
                        transaction.setAmount(credit);
                    }
                    if (fields[3] != null && !"".equals(fields[3])) {
                        BigDecimal debit = new BigDecimal(fields[3].replaceAll("'", ""));
                        transaction.setAmount(debit);
                    }
                    transaction.setValueDate(LocalDate.parse(fields[4], formatter));
                    transactions.add(transaction);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        Reader reader = new InputStreamReader(inputStream);
        Iterable<CSVRecord> records = CSVFormat.newFormat(';'). parse(reader);
        for (CSVRecord record : records) {

        }
        */
        return transactions;
    }
}
