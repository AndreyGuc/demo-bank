package com.cibofff.demobank.repositories;

import com.cibofff.demobank.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
Optional<CreditCard> findByFullName(String fullName);
}
