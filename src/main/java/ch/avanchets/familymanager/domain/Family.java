package ch.avanchets.familymanager.domain;

import ch.avanchets.familymanager.domain.bank.BankAccount;

import java.util.List;

/**
 * Created by rafal on 09-Nov-16.
 */
public class Family {
    private List<FamilyMember> members;
    private List<BankAccount> bankAccounts;
    private List<CreditCard> creditCards;
}
