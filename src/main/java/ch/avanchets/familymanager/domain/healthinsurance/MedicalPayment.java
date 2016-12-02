package ch.avanchets.familymanager.domain.healthinsurance;

import ch.avanchets.familymanager.domain.Person;

import java.time.LocalDate;

/**
 * Created by Rafal Lyzwa on 09-Nov-16.
 */
public class MedicalPayment {
    private InsuredPerson insuredPerson;
    private LocalDate invoicedOn;

    public InsuredPerson getInsuredPerson() {
        return insuredPerson;
    }

    public LocalDate getInvoicedOn() {
        return invoicedOn;
    }
}
