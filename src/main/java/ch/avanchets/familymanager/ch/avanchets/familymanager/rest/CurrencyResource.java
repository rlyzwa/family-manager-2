package ch.avanchets.familymanager.ch.avanchets.familymanager.rest;

import ch.avanchets.familymanager.domain.Currency;
import ch.avanchets.familymanager.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal Lyzwa on 23-Nov-16.
 */
@RestController
@RequestMapping("/api/currencies/")
public class CurrencyResource {

    private CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyResource(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Currency> all() {
        List<Currency> currencies
        = currencyRepository.findAll();
        System.out.println("currencies count = " + currencies.size());
        return currencies;
    }
}
