package com.cibofff.demobank.services;

import com.cibofff.demobank.models.CreditCard;
import com.cibofff.demobank.models.DebitCard;
import com.cibofff.demobank.models.Deposit;
import com.cibofff.demobank.repositories.DebitCardRepository;
import com.cibofff.demobank.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class DepositService {

    //    валюта, баланс и название  //     пополнение запрос баланса закрытие

    private final DepositRepository depositRepository;
    @Autowired
    public DepositService(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public List<Deposit> findAll(){return depositRepository.findAll();}

    public Deposit findOne(int id){
        Optional<Deposit> foundPerson = depositRepository.findById(id);
        return foundPerson.orElse(null) ;}

    @Transactional
    public void save(Deposit CreditCard){ depositRepository.save(CreditCard);}

    @Transactional
    public void update(int id, Deposit updatedCreditCard){
        updatedCreditCard.setId(id);
        depositRepository.save(updatedCreditCard);
    }

    @Transactional
    public void delete(int id){depositRepository.deleteById(id);}

    public Optional<Deposit> getCreditCardByFullName(String fullName){
        return depositRepository.findByFullName(fullName);
    }

    //    валюта, баланс и название //    пополнение списание запрос баланса

    @Transactional
    public void balanceTopUp (int cardId, int sum, String currency){
        if(currency.equals("rubles")){
            Deposit deposit = findOne(cardId);
            deposit.setBalance(sum);
        }else {
            System.out.println("Set Rubles, please");
        }
    }

    @Transactional
    public void showBalance (int cardId){
        int currentBalance = getCurrentBalance(cardId);
        System.out.println(currentBalance);}

    @Transactional
    public int getCurrentBalance(int cardId) {
        Deposit deposit = findOne(cardId);
        int currentBalance = deposit.getBalance();
        return currentBalance;
    }

    @Transactional
    public void depositClosing (int cardId) {
        Deposit deposit = findOne(cardId);
        int currentBalance = deposit.getBalance();
        if (currentBalance > 0) {
                deposit.setBalance(0);
            System.out.println("you have withdrawn the entire balance of the deposit. Your deposit is closed");
            } else {
                System.out.println("Ваш депозит закрыт");
            }
        }
    }
