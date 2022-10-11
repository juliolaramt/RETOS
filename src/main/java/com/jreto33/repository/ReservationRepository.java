package com.jreto33.repository;

import com.jreto33.modelo.ReservationModel;
import com.jreto33.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservations() {
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(Integer idReservation) {
        return reservationCrudRepository.findById(idReservation);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel ){

        return reservationCrudRepository.save(reservationModel);
    }

    public boolean deleteReservation(Integer idReservation){
        reservationCrudRepository.deleteById(idReservation);
        return true;
    }

    public ReservationModel updateReservation (ReservationModel reservationModel ){
        return reservationCrudRepository.save(reservationModel);
    }
}
