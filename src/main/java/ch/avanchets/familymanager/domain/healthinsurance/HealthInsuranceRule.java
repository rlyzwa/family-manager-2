package ch.avanchets.familymanager.domain.healthinsurance;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Rafal Lyzwa on 10-Nov-16.
 */
public interface HealthInsuranceRule {

    BigDecimal resolve(LocalDate resolvedOn, MedicalPayment payment, BigDecimal currentResult);
}
