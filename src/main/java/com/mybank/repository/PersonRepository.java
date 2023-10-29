package com.mybank.repository;

import com.mybank.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByPersonalId(String personalId);
}
