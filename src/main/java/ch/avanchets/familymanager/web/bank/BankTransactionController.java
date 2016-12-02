package ch.avanchets.familymanager.web.bank;

import ch.avanchets.familymanager.domain.bank.BankTransaction;
import ch.avanchets.familymanager.parsers.UbsParser;
import ch.avanchets.familymanager.repositories.bank.BankTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal Lyzwa on 24-Nov-16.
 */
@Controller
public class BankTransactionController {

    private BankTransactionsRepository bankTransactionsRepository;

    @Autowired
    public BankTransactionController(BankTransactionsRepository bankTransactionsRepository) {
        this.bankTransactionsRepository = bankTransactionsRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        System.out.println("I am here");
        model.addAttribute("files", new ArrayList<String>());
        return "uploadForm";
    }



}
