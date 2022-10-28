package com.cibofff.demobank.models;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Client")
public class Client{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "client")
    private List<CreditCard> creditCard;

    @OneToMany(mappedBy = "client")
    private List<DebitCard> debitCard;

    @OneToMany(mappedBy = "client")
    private List<Deposit> deposit;

    @OneToMany(mappedBy = "client")
    private List<ForeignCurrencyDebitCard> foreignCurrencyDebitCard;

    public Client(List<CreditCard> creditCard, List<DebitCard> debitCard, List<Deposit> deposit, List<ForeignCurrencyDebitCard> foreignCurrencyDebitCard) {
        this.creditCard = creditCard;
        this.debitCard = debitCard;
        this.deposit = deposit;
        this.foreignCurrencyDebitCard = foreignCurrencyDebitCard;
    }

    public Client() {

    }

    public int getId() {
        return id;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public List<DebitCard> getDebitCard() {
        return debitCard;
    }

    public List<Deposit> getDeposit() {
        return deposit;
    }

    public List<ForeignCurrencyDebitCard> getForeignCurrencyDebitCard() {
        return foreignCurrencyDebitCard;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }

    public void setDebitCard(List<DebitCard> debitCard) {
        this.debitCard = debitCard;
    }

    public void setDeposit(List<Deposit> deposit) {
        this.deposit = deposit;
    }

    public void setForeignCurrencyDebitCard(List<ForeignCurrencyDebitCard> foreignCurrencyDebitCard) {
        this.foreignCurrencyDebitCard = foreignCurrencyDebitCard;
    }
}
