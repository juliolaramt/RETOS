package com.jreto33.repository.crudrepository;

import com.jreto33.modelo.ReservationModel;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {
}
