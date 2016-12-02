package ch.avanchets.familymanager.domain.healthinsurance.rules;

import ch.avanchets.familymanager.domain.healthinsurance.HealthInsuranceRule;
import ch.avanchets.familymanager.domain.healthinsurance.MedicalPayment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 *
 * Created by Rafal Lyzwa on 10-Nov-16.
 */
public class ChisNoOlderThanOneYearRule implements HealthInsuranceRule {
    public BigDecimal resolve(LocalDate resolvedOn, MedicalPayment payment, BigDecimal currentResult) {

        if (resolvedOn.minusYears(1).isBefore(payment.getInvoicedOn())) {
            return currentResult;
        } else {
            return BigDecimal.ZERO;
        }
    }
}
