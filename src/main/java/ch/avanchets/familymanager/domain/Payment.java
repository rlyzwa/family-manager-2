package ch.avanchets.familymanager.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by rafal on 08-Nov-16.
 */
public class Payment {
    private Date payableBefore;
    private Date executedOn;
    private BigDecimal amount;
    private Currency ccy;
    private String beneficiary;
}
