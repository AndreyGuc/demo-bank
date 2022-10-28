package com.cibofff.demobank.models;

import javax.persistence.*;

@Entity
@Table(name = "Deposit")
public class Deposit {
//    валюта, баланс и название  //     пополнение запрос баланса закрытие
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

    public Deposit(String name, String currency, int balance) {
        this.name = name;
        this.currency = currency;
        this.balance = balance;
    }

    public Deposit() {

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

//     пополнение запрос баланса закрытие
}
