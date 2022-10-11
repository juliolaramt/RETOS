package com.jreto33.repository.crudrepository;

import com.jreto33.modelo.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel, Integer> {
}
