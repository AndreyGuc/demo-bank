package com.cibofff.demobank.repositories;

import com.cibofff.demobank.models.Client;
import com.cibofff.demobank.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository  extends JpaRepository<Client, Integer> {
    Optional<Client> findByFullName(String fullName);
}
