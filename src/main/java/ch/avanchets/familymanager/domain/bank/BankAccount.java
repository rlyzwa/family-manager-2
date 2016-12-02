package ch.avanchets.familymanager.domain.bank;

import ch.avanchets.familymanager.domain.Currency;

import javax.persistence.*;
import java.util.List;

/**
 *
 * Created by Rafal Lyzwa on 09-Nov-16.
 */
@Entity
@Table(name = "accounts")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String iban;
    private String description;

    @ManyToOne
    private Currency nominalCcy;

    @ManyToOne
    private Bank bank;

    private BankAccountType accountType;

    @OneToMany(mappedBy = "account")
    private List<BankTransaction> transactions;


    public BankAccount() {}

    public long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public String getDescription() {
        return description;
    }

    public Currency getNominalCcy() {
        return nominalCcy;
    }

    public Bank getBank() {
        return bank;
    }
}
