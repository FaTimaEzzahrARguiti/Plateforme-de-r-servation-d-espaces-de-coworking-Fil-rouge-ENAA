package com.example.coworking.Dto;



import com.example.coworking.Enum.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    private Long id;
    private String name;
    private Type type;
    private String description;
    private String capacity;
    private String image;
    private Double price;
}