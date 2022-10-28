package com.cibofff.demobank.repositories;

import com.cibofff.demobank.models.ForeignCurrencyDebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ForeignCurrencyDebitCardRepository extends JpaRepository<ForeignCurrencyDebitCard, Integer> {
Optional<ForeignCurrencyDebitCard> findByFullName(String fullName);
}
