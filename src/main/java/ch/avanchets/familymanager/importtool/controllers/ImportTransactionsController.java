package ch.avanchets.familymanager.importtool.controllers;

import ch.avanchets.familymanager.domain.bank.BankTransaction;
import ch.avanchets.familymanager.parsers.PostFinanceParser;
import ch.avanchets.familymanager.parsers.TransactionsParser;
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
 * Created by Rafal Lyzwa on 30-Nov-16.
 */
@Controller
@RequestMapping("/importtool/bank/transactions")
public class ImportTransactionsController {

    private BankTransactionsRepository bankTransactionsRepository;

    @Autowired
    public ImportTransactionsController(BankTransactionsRepository bankTransactionsRepository) {
        this.bankTransactionsRepository = bankTransactionsRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("files", new ArrayList<String>());
        System.out.println("list called");
        return "/importtool/bank/transactions/index.html";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("type") String fileType,
                                   RedirectAttributes redirectAttributes) throws IOException {


        TransactionsParser parser = null;
        if (fileType.equals("UBS")) parser = new UbsParser();
        if (fileType.equals("POST")) parser = new PostFinanceParser();

        if (parser != null) {
            List<BankTransaction> transactions = parser.parseTransactions(file.getInputStream());

            transactions.forEach(t -> bankTransactionsRepository.save(t));

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");

        }
        return "redirect:/importtool/bank/transactions/index.html";
    }
}
