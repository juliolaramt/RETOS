package com.jreto33.repository;

import com.jreto33.modelo.ClientModel;
import com.jreto33.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAllClients() {
        return (List<ClientModel>) clientCrudRepository.findAll();
    }

    public Optional<ClientModel> getClient(Integer idClient) {
        return clientCrudRepository.findById(idClient);
    }

    public ClientModel saveClient(ClientModel clientModel ){ return clientCrudRepository.save(clientModel);
    }

    public boolean deleteClient(Integer idClient){ clientCrudRepository.deleteById(idClient);
        return true;
    }

    public ClientModel updateClient(ClientModel clientModel ){
        return clientCrudRepository.save(clientModel);
    }
}
