package com.jreto33.controller;


import com.jreto33.modelo.DoctorModel;
import com.jreto33.modelo.ReservationModel;
import com.jreto33.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping(("/all"))
    public List<ReservationModel> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/{idReservation}")
    public Optional<ReservationModel> getReservation(@PathVariable Integer idReservation){
        return reservationService.getReservation(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel saveReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.saveReservation(reservationModel);
    }
    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable Integer idReservation){
        return reservationService.deleteReservation(idReservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationModel updateReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.updateReservation(reservationModel);
    }
}
