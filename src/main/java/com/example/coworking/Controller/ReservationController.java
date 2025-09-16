package com.example.coworking.Controller;

import com.example.coworking.Dto.ReservationDTO;
import com.example.coworking.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
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

    @GetMapping
    public List<ReservationDTO> getAllReservations() {
        return reservationService.GetReservations();
    }

    @PutMapping("/{id}")
    public ReservationDTO updateReservation(@PathVariable Long id, @RequestBody ReservationDTO reservationDTO) {
        return reservationService.updateReservation(id, reservationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }

    @GetMapping("/{id}")
    public ReservationDTO getReservationById(@PathVariable Long id) {
        return reservationService.findReservationById(id);
    }

    @GetMapping("/coworking-space/{spaceId}")
    public List<ReservationDTO> getReservationsByCoworkingSpaceId(@PathVariable Long spaceId) {
        return reservationService.getReservationsByCoworkingSpaceId(spaceId);
    }
}