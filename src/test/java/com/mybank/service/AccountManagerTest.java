package com.mybank.service;

import com.mybank.model.Account;
import com.mybank.model.Person;
import com.mybank.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountManagerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private AccountManager accountManager;

    @Test
    void createAccountOk() {

        Person person = new Person("Jan", "Alexander", "123456", new ArrayList<>());
        Account initAccount = new Account(null, 0.0, "CZK", person);
        person.getAccounts().add(initAccount);

        Account account = accountManager.createAccount("Jan", "Alexander", "123456", "CZK");
        assertThat(account)
                .usingRecursiveComparison()
                .isEqualTo(initAccount);
    }

    @Test
    void createAccountAlreadyExistsException() {
        Person person = new Person("Jan", "Alexander", "123456", new ArrayList<>());
        Account initAccount = new Account(1L, 10.5, "CZK", person);
        person.getAccounts().add(initAccount);
        when(personRepository.findByPersonalId(any())).thenReturn(person);

        assertThrows(IllegalArgumentException.class,
                () -> accountManager.createAccount("Jan", "Alexander", "123456", "CZK"));
    }
}
