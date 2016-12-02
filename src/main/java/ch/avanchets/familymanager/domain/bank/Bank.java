package ch.avanchets.familymanager.domain.bank;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rafal on 09-Nov-16.
 */
@Entity
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;

    @OneToMany(mappedBy = "bank")
    private List<BankAccount> accounts;

    public Bank() {}

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
