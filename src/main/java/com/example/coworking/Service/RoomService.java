package com.example.coworking.Service;

import com.example.coworking.Dto.RoomDTO;
import com.example.coworking.Entity.CoworkingSpace;
import com.example.coworking.Entity.Room;
import com.example.coworking.Mapper.RoomMapper;
import com.example.coworking.Repository.CoworkingSpaceRepository;
import com.example.coworking.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    private final CoworkingSpaceRepository coworkingSpaceRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper, CoworkingSpaceRepository coworkingSpaceRepository) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
        this.coworkingSpaceRepository = coworkingSpaceRepository;
    }

    public RoomDTO createRoom(RoomDTO roomDTO) {
        // ✅ Hadiya hiya l-ligne li kat-3ti l-ID l-l-méthode
        CoworkingSpace space = coworkingSpaceRepository.findById(roomDTO.getCoworkingSpaceId())
                .orElseThrow(() -> new RuntimeException("Coworking Space not found"));

        // ... reste du code ...
        Room room = roomMapper.toEntity(roomDTO);
        room.setSpace(space);
        Room savedRoom = roomRepository.save(room);
        return roomMapper.toDTO(savedRoom);
    }

    public RoomDTO getRoomById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        return room.map(roomMapper::toDTO).orElse(null);
    }

    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(roomMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO updateRoom(Long id, RoomDTO roomDTO) {
        Optional<Room> existingRoom = roomRepository.findById(id);
        if (existingRoom.isPresent()) {
            Room room = roomMapper.toEntity(roomDTO);
            room.setId(id);

            // N-3awdou n-settiw l-CoworkingSpace bach ma t-3tana erreur
            CoworkingSpace space = coworkingSpaceRepository.findById(roomDTO.getCoworkingSpaceId())
                    .orElseThrow(() -> new RuntimeException("Coworking Space not found"));
            room.setSpace(space);

            Room updatedRoom = roomRepository.save(room);
            return roomMapper.toDTO(updatedRoom);
        }
        return null;
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    // ✅ Zid hadi, li gha t-jib rooms ghir b-l-ID dyal l-space
    public List<RoomDTO> getRoomsByCoworkingSpaceId(Long spaceId) {
        return roomRepository.findBySpaceId(spaceId)
                .stream()
                .map(roomMapper::toDTO)
                .collect(Collectors.toList());
    }
}