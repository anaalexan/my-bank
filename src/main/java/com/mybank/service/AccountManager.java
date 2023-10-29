package com.mybank.service;

import com.mybank.model.Account;
import com.mybank.model.Person;
import com.mybank.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountManager {

    private final PersonRepository personRepository;

    public Account createAccount(String firstName, String lastName, String personalId, String currency ){
        Person person = createPerson(firstName, lastName, personalId);
        Optional<Account> accountOptional = person.getAccounts().stream().filter(account1 -> account1.getCurrency().equals(currency)).findAny();
        if(accountOptional.isPresent()){
            String message = "Person with id:" + personalId + " already has the account in " + currency;
            log.info(message);
            throw new IllegalArgumentException(message);
        }
        Account account = new Account(null, 0, currency, person);
        person.getAccounts().add(account);
        return account;
    }
    private Person createPerson(String firstName, String lastName, String personalId){
        Person person = personRepository.findByPersonalId(personalId);
        if(person != null){
            return person;
        }else {
            if (isInvalidName(firstName)) {
                throw new IllegalArgumentException("First name should contain at least 1 letter. Name can contain big or small letter and space or \"-\".");
            }
            if (isInvalidName(lastName)) {
                throw new IllegalArgumentException("Last name should contain at least 1 letter. Name can contain big or small letter and space or \"-\".");
            }
            if (!personalId.matches("^[a-zA-Z0-9]{4,15}$")) {
                throw new IllegalArgumentException("Personal ID can only contain letters(big or small) and numbers. And can be long al least 4 and maximum 15 symbols.");
            }
            return new Person(firstName, lastName, personalId, new ArrayList<>());
        }
    }
    private boolean isInvalidName(String name){
        return !name.matches("(^[a-zA-Z])([ a-zA-Z-]{1,30}$)");
    }

    public Account addMoney(String personalId, double amount, String currency){
        Person person = personRepository.findByPersonalId(personalId);
        if(person == null){
            throw new IllegalArgumentException("Person with id:" + personalId + "does not have account in our bank.");
        }
        Optional<Account> account = person.getAccounts().stream().filter(account1 -> account1.getCurrency().equals(currency)).findAny();
        if(account.isEmpty()){
            throw new IllegalArgumentException("Person with id:" + personalId + "does not have account in " + currency);
        }
        account.get().setAmount(account.get().getAmount() + amount);
        return account.get();
    }



}




