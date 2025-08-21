package com.crud.clientes.services;

import com.crud.clientes.dto.ClientDTO;
import com.crud.clientes.entities.Client;
import com.crud.clientes.repositories.ClientRepository;
import com.crud.clientes.services.exceptions.DatabaseException;
import com.crud.clientes.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insertClient(ClientDTO dto) {
        Client clientEntity = new Client();
        dtoToEntity(dto, clientEntity);
        clientEntity = clientRepository.save(clientEntity);
        return new ClientDTO(clientEntity);
    }

    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO dto) {
        Client clientEntity = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        dtoToEntity(dto, clientEntity);
        clientEntity = clientRepository.save(clientEntity);
        return new ClientDTO(clientEntity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            clientRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void dtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }


}
