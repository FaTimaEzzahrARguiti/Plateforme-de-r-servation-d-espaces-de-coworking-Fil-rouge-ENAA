package com.example.coworking.Mapper;



import com.example.coworking.Dto.RoomDTO;
import com.example.coworking.Entity.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {
    public RoomDTO toDTO(Room room) {
        if (room == null) {
            return null;
        }
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setType(room.getType());
        roomDTO.setDescription(room.getDescription());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setImage(room.getImage());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setAvailable(room.isAvailable());
        if (room.getSpace() != null) {
            roomDTO.setCoworkingSpaceId(room.getSpace().getId());
        }

        return roomDTO;
    }

    public Room toEntity(RoomDTO roomDTO) {
        if (roomDTO == null) {
            return null;
        }
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setType(roomDTO.getType());
        room.setDescription(roomDTO.getDescription());
        room.setCapacity(roomDTO.getCapacity());
        room.setImage(roomDTO.getImage());
        room.setPrice(roomDTO.getPrice());
        room.setAvailable(roomDTO.isAvailable());
        return room;
    }
}