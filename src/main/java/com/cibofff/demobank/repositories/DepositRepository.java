package com.cibofff.demobank.repositories;

import com.cibofff.demobank.models.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer> {
Optional<Deposit> findByFullName(String fullName);
}
