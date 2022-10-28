package com.cibofff.demobank.services;

import com.cibofff.demobank.models.ForeignCurrencyDebitCard;
import com.cibofff.demobank.repositories.ForeignCurrencyDebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class ForeignCurrencyDebitCardService {

    //    валюта, баланс и название  //    пополнение списание запрос баланса

        private final ForeignCurrencyDebitCardRepository foreignCurrencyDebitCardRepository;

    @Autowired
    public ForeignCurrencyDebitCardService(ForeignCurrencyDebitCardRepository foreignCurrencyDebitCardRepository) {
        this.foreignCurrencyDebitCardRepository = foreignCurrencyDebitCardRepository;
    }

        public List<ForeignCurrencyDebitCard> findAll(){return foreignCurrencyDebitCardRepository.findAll();}

        public ForeignCurrencyDebitCard findOne(int id){
        Optional<ForeignCurrencyDebitCard> foundPerson = foreignCurrencyDebitCardRepository.findById(id);
        return foundPerson.orElse(null) ;}

        @Transactional
        public void save(ForeignCurrencyDebitCard CreditCard){ foreignCurrencyDebitCardRepository.save(CreditCard);}

        @Transactional
        public void update(int id, ForeignCurrencyDebitCard updatedCreditCard){
        updatedCreditCard.setId(id);
            foreignCurrencyDebitCardRepository.save(updatedCreditCard);
    }

        @Transactional
        public void delete(int id){foreignCurrencyDebitCardRepository.deleteById(id);}

        public Optional<ForeignCurrencyDebitCard> getCreditCardByFullName(String fullName){
        return foreignCurrencyDebitCardRepository.findByFullName(fullName);
    }

        //    валюта, баланс и название //    пополнение списание запрос баланса

        @Transactional
        public void balanceTopUp (int cardId, int sum, String currency){
        if(currency.equals("rubles")){
            ForeignCurrencyDebitCard debitCard = findOne(cardId);
            debitCard.setBalance(sum);
        }else {
            System.out.println("Set Rubles, please");
        }
    }

        @Transactional
        public void getBalance (int cardId){
        ForeignCurrencyDebitCard debitCard = findOne(cardId);
        int currentBalance = debitCard.getBalance();
        System.out.println(currentBalance);}
    }
