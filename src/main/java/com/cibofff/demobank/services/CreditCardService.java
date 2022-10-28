package com.cibofff.demobank.services;

import com.cibofff.demobank.models.CreditCard;
import com.cibofff.demobank.repositories.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public List<CreditCard> findAll(){return creditCardRepository.findAll();}

    public CreditCard findOne(int id){
        Optional<CreditCard> foundPerson = creditCardRepository.findById(id);
        return foundPerson.orElse(null) ;}

    @Transactional
    public void save(CreditCard CreditCard){ creditCardRepository.save(CreditCard);}

    @Transactional
    public void update(int id, CreditCard updatedCreditCard){
        updatedCreditCard.setId(id);
        creditCardRepository.save(updatedCreditCard);
    }

    @Transactional
    public void delete(int id){creditCardRepository.deleteById(id);}

    public Optional<CreditCard> getCreditCardByFullName(String fullName){
        return creditCardRepository.findByFullName(fullName);
    }

    //пополнение
    //только рубли доступны к пополнению
    @Transactional
    public void balanceTopUp (int cardId, int sum, String currency){
        if(currency.equals("rubles")){
            CreditCard creditCard = findOne(cardId);
            creditCard.setBalance(sum);
        }else {
            System.out.println("Set Rubles, please");
        }
    }

    @Transactional
    public void balanceWrightOff (int cardId, int sum, String currency) {
        if (currency.equals("rubles")) {
            CreditCard creditCard = findOne(cardId);
            int currentBalance = creditCard.getBalance();
            int difference = currentBalance - sum;
            if (difference > 0) {
                creditCard.setBalance(difference);
            } else {
                creditCard.setBalance(difference);
                System.out.println("You use funds in debt");
            }
        } else {
            System.out.println("Set Rubles, please");
        }
    }

    @Transactional
    public void getBalance (int cardId){
        CreditCard creditCard = findOne(cardId);
        int currentBalance = creditCard.getBalance();
            System.out.println(currentBalance);}

        @Transactional
        public void debtRequest (int cardId){

                CreditCard creditCard = findOne(cardId);
                int currentBalance = creditCard.getBalance();

                if(currentBalance > 0){
                    System.out.println("You have not debt");
                }else {
                    System.out.println("You current debt" + Math.abs(currentBalance));
                }
    }



    //    валюта, баланс и название процентная ставка пополнение списание запрос баланса, запрос задолженност
}
