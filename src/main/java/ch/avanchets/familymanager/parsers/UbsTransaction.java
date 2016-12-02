package ch.avanchets.familymanager.parsers;

import ch.avanchets.familymanager.domain.bank.BankTransaction;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Rafal Lyzwa on 21-Nov-16.
 */
public class UbsTransaction extends BankTransaction {
    private String description;
    private BigDecimal individualAmount;

    private BigDecimal balance;

    public static class Builder {
        private UbsTransaction transaction;

        public Builder() {
            this.transaction = new UbsTransaction();
        }

        public Builder setTransactionDate(LocalDate transactionDate) {
            transaction.setTransactionDate(transactionDate);
            return this;
        }

        public Builder setAccountingDate(LocalDate accountingDate) {
            transaction.setAccountingDate(accountingDate);
            return this;
        }

        public Builder setValueDate(LocalDate valueDate) {
            transaction.setValueDate(valueDate);
            return this;
        }

        public Builder setDescription(String description) {
            transaction.description = description;
            return this;
        }

        public Builder setReference(String reference) {
            transaction.setReference(reference);
            return this;
        }

        public Builder setIndividualAmount(BigDecimal individualAmount) {
            transaction.individualAmount = individualAmount;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            transaction.setAmount(amount);
            return this;
        }


        public Builder setBalance(BigDecimal balance) {
            transaction.balance = balance;
            return this;
        }

        public UbsTransaction build() {
            return transaction;
        }
    }

    private UbsTransaction() {}


    public String getDescription() {
        return description;
    }

    public BigDecimal getIndividualAmount() {
        return individualAmount;
    }

}
