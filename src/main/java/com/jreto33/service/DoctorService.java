package com.jreto33.service;

import com.jreto33.modelo.DoctorModel;
import com.jreto33.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorModel> getAllDoctors() {
        return doctorRepository.getAllDoctors();
    }

    public Optional<DoctorModel> getDoctor(Integer id) {
        return doctorRepository.getDoctor(id);
    }

    public DoctorModel saveDoctor(DoctorModel doctorModel) {
        return doctorRepository.saveDoctor(doctorModel);
    }

    /*
public boolean deleteDoctor(Integer id) {
    return doctorRepository.deleteDoctor(id);
}
*/
    public boolean deleteDoctor(int id) {
        boolean flag = false;
        Optional<DoctorModel> e = doctorRepository.getDoctor(id);
        if (e.isPresent()) {
            doctorRepository.deleteDoctor(e.get());
            flag = true;
        }
        return flag;
    }

    /*
        public DoctorModel updateDoctor(DoctorModel doctorModel) {
            return doctorRepository.updateDoctor(doctorModel);
        }
    */
    public DoctorModel updateDoctor(DoctorModel doctorModel) {
        if (doctorModel.getId() != null) {
            Optional<DoctorModel> e = doctorRepository.getDoctor(doctorModel.getId());
            if (e.isPresent()) {
                if (doctorModel.getName() != null) {
                    e.get().setName(doctorModel.getName());
                }
                if (doctorModel.getDepartment() != null) {
                    e.get().setDepartment(doctorModel.getDepartment());
                }
                if (doctorModel.getYear() != null) {
                    e.get().setYear(doctorModel.getYear());
                }
                if (doctorModel.getDescription() != null) {
                    e.get().setDescription(doctorModel.getDescription());
                }
                if (doctorModel.getMessages() != null) {
                    e.get().setMessages(doctorModel.getMessages());
                }
                if (doctorModel.getSpecialty() != null) {
                    e.get().setSpecialty(doctorModel.getSpecialty());
                }
                if (doctorModel.getReservations() != null) {
                    e.get().setReservations(doctorModel.getReservations());
                }
                doctorRepository.saveDoctor(e.get());
                return e.get();
            } else {
                return doctorModel;
            }
        } else {
            return doctorModel;
        }
    }
}