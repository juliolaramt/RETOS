package com.jreto33.service;

import com.jreto33.modelo.ClientModel;
import com.jreto33.modelo.ReservationModel;
import com.jreto33.modelo.SpecialtyModel;
import com.jreto33.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<SpecialtyModel> getAllSpecialties(){
        return specialtyRepository.getAllSpecialties();
    }

    public Optional<SpecialtyModel> getSpecialty(Integer id){
        return specialtyRepository.getSpecialty(id);
    }

    public SpecialtyModel saveSpecialty(SpecialtyModel specialtyModel){
        return specialtyRepository.saveSpecialty(specialtyModel);
    }

    //public boolean deleteSpecialty (Integer id){
    //    return specialtyRepository.deleteSpecialty(id);
    //}
    public boolean deleteSpecialty(int id){
        boolean flag=false;
        Optional<SpecialtyModel> e = specialtyRepository.getSpecialty(id);
        if(e.isPresent()){
            specialtyRepository.deleteSpecialty(e.get());
            flag = true;
        }
        return flag;
    }

    //public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel){
    //    return specialtyRepository.updateSpecialty(specialtyModel);
    //}
    public SpecialtyModel updateSpecialty(SpecialtyModel specialtyModel) {
        if (specialtyModel.getId() != null) {
            Optional<SpecialtyModel> e = specialtyRepository.getSpecialty(specialtyModel.getId());
            if (e.isPresent()) {
                if (specialtyModel.getName() != null) {
                    e.get().setName(specialtyModel.getName());
                }
                if (specialtyModel.getDescription() != null) {
                    e.get().setDescription(specialtyModel.getDescription());
                }
                if (specialtyModel.getDoctors() != null) {
                    e.get().setDoctors(specialtyModel.getDoctors());
                }
                specialtyRepository.saveSpecialty(e.get());
                return e.get();
            } else {
                return specialtyModel;
            }
        } else {
            return specialtyModel;
        }
    }

}
