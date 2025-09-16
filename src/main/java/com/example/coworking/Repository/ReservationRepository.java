package com.example.coworking.Repository;

import com.example.coworking.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    List<Reservation> findByRoom_Space_Id(Long id);

    List<Reservation> findReservationsByStartTimeBetween(LocalDate a,LocalDate b);
}
