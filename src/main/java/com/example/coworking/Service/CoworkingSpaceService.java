package com.example.coworking.Service;


import com.example.coworking.Dto.CoworkingSpaceDTO;
import com.example.coworking.Entity.CoworkingSpace;
import com.example.coworking.Mapper.CoworkingSpaceMapper;
import com.example.coworking.Repository.CoworkingSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoworkingSpaceService {

    private final CoworkingSpaceRepository coworkingSpaceRepository;
    private final CoworkingSpaceMapper coworkingSpaceMapper;

    @Autowired
    public CoworkingSpaceService(CoworkingSpaceRepository coworkingSpaceRepository, CoworkingSpaceMapper coworkingSpaceMapper) {
        this.coworkingSpaceRepository = coworkingSpaceRepository;
        this.coworkingSpaceMapper = coworkingSpaceMapper;
    }
public CoworkingSpaceDTO createSpace(CoworkingSpaceDTO coworkingSpaceDTO){
        CoworkingSpace coworkingSpace= coworkingSpaceMapper.toEntity(coworkingSpaceDTO);
        CoworkingSpace saved= coworkingSpaceRepository.save(coworkingSpace);
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

public void deleteSpace(Long id){
        coworkingSpaceRepository.deleteById(id);
}

}
