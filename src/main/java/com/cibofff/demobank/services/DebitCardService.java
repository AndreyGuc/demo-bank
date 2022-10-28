package com.cibofff.demobank.services;

import com.cibofff.demobank.models.CreditCard;
import com.cibofff.demobank.models.DebitCard;
import com.cibofff.demobank.repositories.CreditCardRepository;
import com.cibofff.demobank.repositories.DebitCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DebitCardService {

    private final DebitCardRepository debitCardRepository;
    @Autowired
    public DebitCardService(DebitCardRepository debitCardRepository) {
        this.debitCardRepository = debitCardRepository;
    }

    public List<DebitCard> findAll(){return debitCardRepository.findAll();}

    public DebitCard findOne(int id){
        Optional<DebitCard> foundPerson = debitCardRepository.findById(id);
        return foundPerson.orElse(null) ;}

    @Transactional
    public void save(DebitCard CreditCard){ debitCardRepository.save(CreditCard);}

    @Transactional
    public void update(int id, DebitCard updatedCreditCard){
        updatedCreditCard.setId(id);
        debitCardRepository.save(updatedCreditCard);
    }

    @Transactional
    public void delete(int id){debitCardRepository.deleteById(id);}

    public Optional<DebitCard> getCreditCardByFullName(String fullName){
        return debitCardRepository.findByFullName(fullName);
    }

    //    валюта, баланс и название //    пополнение списание запрос баланса

    @Transactional
    public void balanceTopUp (int cardId, int sum, String currency){
        if(currency.equals("rubles")){
            DebitCard debitCard = findOne(cardId);
            debitCard.setBalance(sum);
        }else {
            System.out.println("Set Rubles, please");
        }
    }

    @Transactional
    public void balanceWrightOff (int cardId, int sum, String currency) {
        if (currency.equals("rubles")) {
            DebitCard debitCard = findOne(cardId);
            int currentBalance = debitCard.getBalance();
            int difference = currentBalance - sum;
            if (difference > 0) {
                debitCard.setBalance(difference);
            } else {
                debitCard.setBalance(difference);
                System.out.println("You use funds in debt");
            }
        } else {
            System.out.println("Set Rubles, please");
        }
    }

    @Transactional
    public void getBalance (int cardId){
        DebitCard debitCard = findOne(cardId);
        int currentBalance = debitCard.getBalance();
        System.out.println(currentBalance);}
}


