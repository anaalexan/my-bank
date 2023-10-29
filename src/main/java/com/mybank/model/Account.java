package com.mybank.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account{

    @Id
    @Column
    @GeneratedValue
    private Long accountNumber;

    @Column
    private double amount;

    @Column
    private String currency;

    @ManyToOne
    @JoinColumn(name = "personalId")
    private Person person;

}
