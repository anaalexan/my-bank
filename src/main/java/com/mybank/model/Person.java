package com.mybank.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Id
    @Column
    private String personalId;

    @OneToMany(mappedBy="person")
    private List<Account> accounts;

}
