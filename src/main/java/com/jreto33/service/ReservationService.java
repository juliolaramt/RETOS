package com.jreto33.service;

import com.jreto33.modelo.ClientModel;
import com.jreto33.modelo.MessageModel;
import com.jreto33.modelo.ReservationModel;
import com.jreto33.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return reservationRepository.saveReservation(reservationModel);
    }

    //public boolean deleteReservation (Integer idReservation){
    //    return reservationRepository.deleteReservation(idReservation);
    //}
    public boolean deleteReservation(int id){
        boolean flag=false;
        Optional<ReservationModel> e = reservationRepository.getReservation(id);
        if(e.isPresent()){
            reservationRepository.deleteReservation(e.get());
            flag = true;
        }
        return flag;
    }
    //public ReservationModel updateReservation(ReservationModel reservationModel){
    //    return reservationRepository.updateReservation(reservationModel);
    //}

    public ReservationModel updateDoctor(ReservationModel reservationModel) {
        if (reservationModel.getIdReservation() != null) {
            Optional<ReservationModel> e = reservationRepository.getReservation(reservationModel.getIdReservation());
            if (e.isPresent()) {
                if (reservationModel.getStartDate() != null) {
                    e.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                if (reservationModel.getStatus() != null) {
                    e.get().setStatus(reservationModel.getStatus());
                }
                if (reservationModel.getDoctor() != null) {
                    e.get().setDoctor(reservationModel.getDoctor());
                }
                if (reservationModel.getClient() != null) {
                    e.get().setClient(reservationModel.getClient());
                }
                if (reservationModel.getScore() != null) {
                    e.get().setScore(reservationModel.getScore());
                }
                reservationRepository.saveReservation(e.get());
                return e.get();
            } else {
                return reservationModel;
            }
        } else {
            return reservationModel;
        }
    }
}
