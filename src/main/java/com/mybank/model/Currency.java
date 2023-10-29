package com.mybank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String currencyFrom;

    @Column
    private Double exchangeRate;

    @Column
    private String currencyTo;

}
