package com.cibofff.demobank.models;

import javax.persistence.*;

@Entity
@Table(name = "CreditCard")
public class CreditCard {
//    валюта, баланс и название процентная ставка пополнение списание запрос баланса, запрос задолженности
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

    @Column(name = "interestRate")
   private int interestRate;

    public CreditCard(String name, String currency, int balance, int interestRate) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public CreditCard() {

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

    public int getInterestRate() {
        return interestRate;
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

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

//    пополнение списание запрос баланса, запрос задолженности
}
