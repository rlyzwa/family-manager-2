package ch.avanchets.familymanager.domain;

import ch.avanchets.familymanager.domain.bank.BankAccount;
import ch.avanchets.familymanager.domain.bank.BankTransaction;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by rafal on 09-Nov-16.
 */
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String number;
    @ManyToOne
    private Currency nominalCcy;
    private BigDecimal limit;
    private LocalDate expiryDate;
    @ManyToOne
    private BankAccount repaymentAccount;
    private List<BankTransaction> repaymentTransactions;
}
