package com.example.coworking.Entity;

import com.example.coworking.Enum.Type;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Type type;
    private String description;
    private String capacity;
    private String image;
    private Double price;
    private boolean isAvailable;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space_id")
    private CoworkingSpace space;
}