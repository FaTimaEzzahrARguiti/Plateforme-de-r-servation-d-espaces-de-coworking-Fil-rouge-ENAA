package com.example.coworking.Dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoworkingSpaceDTO {

    private Long id;
    private String name;
    private String address;
    private String description;

    private List<RoomDTO> rooms;
}