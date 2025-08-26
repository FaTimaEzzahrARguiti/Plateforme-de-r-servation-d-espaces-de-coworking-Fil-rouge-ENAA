package com.example.coworking.Mapper;

import com.example.coworking.Entity.Reservation;
import com.example.coworking.Entity.Room;
import com.example.coworking.Entity.User;
import com.example.coworking.Dto.ReservationDTO;
import org.springframework.stereotype.Component;


@Component
public class ReservationMapper {

    public static ReservationDTO toDTO(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setStartTime(reservation.getStartTime());
        dto.setEndTime(reservation.getEndTime());
        dto.setStatus(reservation.getStatus());
        dto.setTotalPrice(reservation.getTotalPrice());
        dto.setId(reservation.getUser() != null ? reservation.getUser().getId() : null);
        dto.setId(reservation.getRoom() != null ? reservation.getRoom().getId() : null);
        return dto;
    }

    public static Reservation toEntity(ReservationDTO dto, User user, Room room) {
        if (dto == null) {
            return null;
        }
        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setStartTime(dto.getStartTime());
        reservation.setEndTime(dto.getEndTime());
        reservation.setStatus(dto.getStatus());
        reservation.setTotalPrice(dto.getTotalPrice());
        reservation.setUser(user);
        reservation.setRoom(room);
        return reservation;
    }
}
