package com.example.coworking.Mapper;

import com.example.coworking.Dto.CoworkingSpaceDTO;
import com.example.coworking.Entity.CoworkingSpace;
import com.example.coworking.Repository.UserRepository; // Import UserRepository
import org.springframework.stereotype.Component;

@Component
public class CoworkingSpaceMapper {

    private final UserRepository userRepository;

    public CoworkingSpaceMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CoworkingSpace toEntity(CoworkingSpaceDTO dto) {
        CoworkingSpace entity = new CoworkingSpace();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());

        // Hna gha n'chercher l'user b'l'id
        if (dto.getAdminId() != null) {
            userRepository.findById(dto.getAdminId()).ifPresent(entity::setAdmin);
        }
        return entity;
    }

    public CoworkingSpaceDTO toDTO(CoworkingSpace entity) {
        CoworkingSpaceDTO dto = new CoworkingSpaceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());

        // N'zid l'id dial l'admin f DTO ila kan kayn
        if (entity.getAdmin() != null) {
            dto.setAdminId(entity.getAdmin().getId());
        }
        return dto;
    }
}