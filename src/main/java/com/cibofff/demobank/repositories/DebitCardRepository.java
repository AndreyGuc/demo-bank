package com.cibofff.demobank.repositories;

import com.cibofff.demobank.models.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Integer> {
Optional<DebitCard> findByFullName(String fullName);
}
