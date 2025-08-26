package com.example.coworking.Service;


import com.example.coworking.Dto.ReservationDTO;
import com.example.coworking.Entity.Reservation;
import com.example.coworking.Entity.Room;
import com.example.coworking.Entity.User;
import com.example.coworking.Mapper.ReservationMapper;
import com.example.coworking.Repository.ReservationRepository;
import com.example.coworking.Repository.RoomRepository;
import com.example.coworking.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;
    private final RoomRepository roomRepository;

    private final UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper,
                              RoomRepository roomRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }


    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        User user = userRepository.findById(reservationDTO.getId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        Room room = roomRepository.findById(reservationDTO.getId())
                .orElseThrow(() -> new RuntimeException("Salle introuvable"));
        Reservation reservation = reservationMapper.toEntity(reservationDTO, user, room);
        Reservation savedReservation = reservationRepository.save(reservation);

        System.out.println(savedReservation);
        return reservationMapper.toDTO(savedReservation);
    }


    public List<ReservationDTO> GetReservations(){
        return reservationRepository.findAll()
        .stream().map(ReservationMapper::toDTO).collect(Collectors.toList());
    }

    public ReservationDTO findReservationById(Long id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(()->new RuntimeException(("réservation introuvable")));
        return ReservationMapper.toDTO(reservation);
    }



    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }




}
