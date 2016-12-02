package ch.avanchets.familymanager.parsers;

import ch.avanchets.familymanager.domain.bank.BankTransaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal Lyzwa on 14-Nov-16.
 */
public class UbsParser implements TransactionsParser<BankTransaction> {

    private LocalDate parseDate(String textDate) {

        if (textDate == null) return null;
        if ("".equals(textDate)) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate ld = LocalDate.parse(textDate, formatter);

        return ld;
    }

    private BigDecimal parseBigDecimal(String textBigDecimal, BigDecimal defaultValue) {
        if (textBigDecimal == null) return defaultValue;
        if ("".equals(textBigDecimal)) return defaultValue;
        return new BigDecimal(textBigDecimal.replace("'", ""));
    }


    public List<BankTransaction> parseTransactions(InputStream in) {

        Reader reader = new InputStreamReader(in);
        List<BankTransaction> transactions = new ArrayList<>();
        try {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').parse(reader);
            boolean isHeader = true;
            for (CSVRecord record : records) {
                if (!isHeader) {

                    if (record.size() == 21) {
                        BankTransaction transaction = new BankTransaction();
                        transaction.setTransactionDate(parseDate(record.get(9)));
                        transaction.setAccountingDate(parseDate(record.get(10)));
                        transaction.setValueDate(parseDate(record.get(11)));
                        transaction.setDescription(record.get(12) + " " + record.get(13) + " " + record.get(14));
                        transaction.setReference(record.get(15));
//                        transaction.setIndividualAmount(parseBigDecimal(record.get(17), BigDecimal.ZERO));
                        if (record.get(18) != null && !"".equals(record.get(18))) {
                            transaction.setAmount(parseBigDecimal(record.get(18), BigDecimal.ZERO).multiply(BigDecimal.valueOf(-1L)));
                        } else {

                            transaction.setAmount(parseBigDecimal(record.get(19), BigDecimal.ZERO));
                        }
                        transactions.add(transaction);
                    }
                } else {
                    isHeader = false;
                }

            }
            reader.close();
        } catch (IOException ex) {

        }

        return transactions;
    }
}
