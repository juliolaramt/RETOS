package com.jreto33.service;

import com.jreto33.modelo.ClientModel;
import com.jreto33.modelo.DoctorModel;
import com.jreto33.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClients(){
        return clientRepository.getAllClients();
    }
    public Optional<ClientModel> getClient(Integer idClient){
        return clientRepository.getClient(idClient);
    }
    public ClientModel saveClient(ClientModel clientModel){
        return clientRepository.saveClient(clientModel);
    }
    //public boolean deleteClient(Integer idClient){
    //    return clientRepository.deleteClient(idClient);
    //}
    public boolean deleteClient(int id){
        boolean flag=false;
        Optional<ClientModel> e = clientRepository.getClient(id);
        if(e.isPresent()){
            clientRepository.deleteClient(e.get());
            flag = true;
        }
        return flag;
    }
    //public ClientModel updateClient(ClientModel clientModel){
     //   return clientRepository.updateClient(clientModel);
    //}
    public ClientModel updateClient(ClientModel clientModel) {
        if (clientModel.getIdClient() != null) {
            Optional<ClientModel> e = clientRepository.getClient(clientModel.getIdClient());
            if (e.isPresent()) {
                if (clientModel.getEmail() != null) {
                    e.get().setEmail(clientModel.getEmail());
                }
                if (clientModel.getPassword() != null) {
                    e.get().setPassword(clientModel.getPassword());
                }
                if (clientModel.getName() != null) {
                    e.get().setName(clientModel.getName());
                }
                if (clientModel.getAge() != null) {
                    e.get().setAge(clientModel.getAge());
                }
                if (clientModel.getMessages() != null) {
                    e.get().setMessages(clientModel.getMessages());
                }

                if (clientModel.getReservations() != null) {
                    e.get().setReservations(clientModel.getReservations());
                }
                clientRepository.saveClient(e.get());
                return e.get();
            } else {
                return clientModel;
            }
        } else {
            return clientModel;
        }
    }

}
