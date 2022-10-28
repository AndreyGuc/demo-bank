package com.cibofff.demobank.models;

import javax.persistence.*;

@Entity
@Table(name = "ForeignCurrencyDebitCard")
public class ForeignCurrencyDebitCard {
    //    валюта, баланс и название  //    пополнение списание запрос баланса
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "currency")
    private String currency;

    @Column(name = "balance")
    private int balance;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Client client;

    public ForeignCurrencyDebitCard(String name, String currency, int balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    public ForeignCurrencyDebitCard() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

//    пополнение списание запрос баланса
}
