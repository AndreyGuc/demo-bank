package com.cibofff.demobank.services;

import com.cibofff.demobank.models.Client;
import com.cibofff.demobank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepository;

@Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public List<Client> findAll(){return clientRepository.findAll();}

    public Client findOne(int id){
    Optional<Client> foundPerson = clientRepository.findById(id);
    return foundPerson.orElse(null) ;}

    @Transactional
    public void save(Client client){ clientRepository.save(client);}

    @Transactional
    public void update(int id, Client updatedClient){
    updatedClient.setId(id);
    clientRepository.save(updatedClient);
    }

    @Transactional
    public void delete(int id){clientRepository.deleteById(id);}

    public Optional<Client> getClientByFullName(String fullName){
    return clientRepository.findByFullName(fullName);
    }
}
