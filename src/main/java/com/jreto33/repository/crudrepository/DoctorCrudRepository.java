package com.jreto33.repository.crudrepository;

import com.jreto33.modelo.DoctorModel;
import org.springframework.data.repository.CrudRepository;

public interface DoctorCrudRepository  extends CrudRepository<DoctorModel, Integer > {
}
