package com.mybank.controller;

import com.mybank.model.Account;
import com.mybank.model.Person;
import com.mybank.repository.AccountRepository;
import com.mybank.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;

    @ModelAttribute("module")
    String module() {
        return "home";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        log.info("Client requested home page.");

        //TODO just testing
        Account account = accountRepository.findByAccountNumber(2);
        System.out.println(account);

        //TODO just testing
        Person person = personRepository.findByPersonalId("CZ6555hjhg");
        System.out.println(person);

        //TODO just testing
        model.addAttribute("appName", "MyBank");

        return "home";
    }
}