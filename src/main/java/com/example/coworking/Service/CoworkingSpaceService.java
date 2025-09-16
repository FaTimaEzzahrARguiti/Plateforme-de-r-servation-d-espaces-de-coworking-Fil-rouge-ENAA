package com.example.coworking.Service;


import com.example.coworking.Dto.CoworkingSpaceDTO;
import com.example.coworking.Dto.NombreReservation;
import com.example.coworking.Entity.CoworkingSpace;
import com.example.coworking.Entity.Room;
import com.example.coworking.Entity.User;
import com.example.coworking.Mapper.CoworkingSpaceMapper;
import com.example.coworking.Repository.CoworkingSpaceRepository;
import com.example.coworking.Repository.RoomRepository;
import com.example.coworking.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoworkingSpaceService {

    private final CoworkingSpaceRepository coworkingSpaceRepository;
    private final CoworkingSpaceMapper coworkingSpaceMapper;
    private final UserRepository userRepository;

    private final RoomRepository roomRepository;


    @Autowired
    public CoworkingSpaceService(CoworkingSpaceRepository coworkingSpaceRepository, CoworkingSpaceMapper coworkingSpaceMapper, UserRepository userRepository, RoomRepository roomRepository) {
        this.coworkingSpaceRepository = coworkingSpaceRepository;
        this.coworkingSpaceMapper = coworkingSpaceMapper;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }


    public CoworkingSpaceDTO createSpace(CoworkingSpaceDTO coworkingSpaceDTO) {
        Long adminId = coworkingSpaceDTO.getAdminId();

        Optional<User> adminOptional = userRepository.findById(adminId);

        if (adminOptional.isEmpty()) {
            return null;
        }

        com.example.coworking.Entity.User admin = adminOptional.get();

        if (admin.getCoworkingSpace() != null) {
            System.out.println(" l'admin a déjà un Coworking Space!");
            return null;
        }
        CoworkingSpace coworkingSpace = coworkingSpaceMapper.toEntity(coworkingSpaceDTO);

        coworkingSpace.setAdmin(admin);

        admin.setCoworkingSpace(coworkingSpace);

        CoworkingSpace saved = coworkingSpaceRepository.save(coworkingSpace);
        return coworkingSpaceMapper.toDTO(saved);
    }

public CoworkingSpaceDTO getSpaceById(Long id){
        Optional<CoworkingSpace> coworkingSpace = coworkingSpaceRepository.findById(id);
        return coworkingSpace.map(coworkingSpaceMapper::toDTO).orElse(null);
}

public List<CoworkingSpaceDTO> getAllSpaces(){
        return coworkingSpaceRepository.findAll().stream().map(coworkingSpaceMapper::toDTO).collect(Collectors.toList());
}

public CoworkingSpaceDTO updateSpace(Long id,CoworkingSpaceDTO coworkingSpaceDTO){
        Optional<CoworkingSpace> existingSpace= coworkingSpaceRepository.findById(id);
        if(existingSpace.isPresent()){
            CoworkingSpace coworkingSpace=coworkingSpaceMapper.toEntity(coworkingSpaceDTO);

            coworkingSpace.setId(id);
            CoworkingSpace updatedSpace= coworkingSpaceRepository.save(coworkingSpace);
            return coworkingSpaceMapper.toDTO(updatedSpace);
        }
        return null;
}

    public void deleteSpace(Long id) {
        CoworkingSpace space = coworkingSpaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Space not found"));
        coworkingSpaceRepository.delete(space);
    }
public List<NombreReservation> CountReservation(){
        return coworkingSpaceRepository.CountReservation();

}



}
