package com.jreto33.service;

import com.jreto33.modelo.ClientModel;
import com.jreto33.modelo.DoctorModel;
import com.jreto33.modelo.MessageModel;
import com.jreto33.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAllMessages() {
        return messageRepository.getAllMessages();
    }

    public Optional<MessageModel> getMessage(Integer idMessage) {
        return messageRepository.getMessage(idMessage);
    }

    public MessageModel saveMessage(MessageModel messageModel){

        return messageRepository.saveMessage(messageModel);
    }
//    public boolean deleteMessage(Integer idMessage){
//        messageRepository.deleteMessage(idMessage);
//        return true;
// }
    public boolean deleteMessage(int id){
    boolean flag=false;
    Optional<MessageModel> e = messageRepository.getMessage(id);
    if(e.isPresent()){
        messageRepository.deleteMessage(e.get());
        flag = true;
    }
    return flag;
}
    //public MessageModel updateMessage (MessageModel messageModel ){
    //    return messageRepository.updateMessage(messageModel);
    //}
    public MessageModel updateDoctor(MessageModel messageModel) {
        if (messageModel.getIdMessage() != null) {
            Optional<MessageModel> e = messageRepository.getMessage(messageModel.getIdMessage());
            if (e.isPresent()) {
                if (messageModel.getMessageText() != null) {
                    e.get().setMessageText(messageModel.getMessageText());
                }
                if (messageModel.getDoctor() != null) {
                    e.get().setDoctor(messageModel.getDoctor());
                }
                if (messageModel.getClient() != null) {
                    e.get().setClient(messageModel.getClient());
                }
                messageRepository.saveMessage(e.get());
                return e.get();
            } else {
                return messageModel;
            }
        } else {
            return messageModel;
        }
    }
}
