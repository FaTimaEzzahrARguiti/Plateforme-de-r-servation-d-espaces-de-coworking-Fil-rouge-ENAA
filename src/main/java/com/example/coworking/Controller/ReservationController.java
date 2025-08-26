package com.example.coworking.Controller;


import com.example.coworking.Dto.ReservationDTO;
import com.example.coworking.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ReservationDTO addReservation(@RequestBody ReservationDTO reservationDTO){
        System.out.println(reservationDTO);
        return reservationService.addReservation(reservationDTO);
    }

}
