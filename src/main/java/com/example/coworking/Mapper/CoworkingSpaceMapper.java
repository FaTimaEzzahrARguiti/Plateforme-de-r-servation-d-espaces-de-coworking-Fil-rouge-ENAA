package com.example.coworking.Mapper;

import com.example.coworking.Dto.CoworkingSpaceDTO;
import com.example.coworking.Entity.CoworkingSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class CoworkingSpaceMapper {

    @Autowired
    private RoomMapper roomMapper;

    public CoworkingSpaceDTO toDTO(CoworkingSpace space) {
        if (space == null) {
            return null;
        }

        CoworkingSpaceDTO spaceDTO = new CoworkingSpaceDTO();
        spaceDTO.setId(space.getId());
        spaceDTO.setName(space.getName());
        spaceDTO.setAddress(space.getAddress());
        spaceDTO.setDescription(space.getDescription());

        if (space.getRooms() != null) {
            spaceDTO.setRooms(space.getRooms().stream()
                    .map(roomMapper::toDTO)
                    .collect(Collectors.toList()));
        }

        return spaceDTO;
    }

    public CoworkingSpace toEntity(CoworkingSpaceDTO spaceDTO) {
        if (spaceDTO == null) {
            return null;
        }

        CoworkingSpace space = new CoworkingSpace();
        space.setId(spaceDTO.getId());
        space.setName(spaceDTO.getName());
        space.setAddress(spaceDTO.getAddress());
        space.setDescription(spaceDTO.getDescription());

        return space;
    }
}