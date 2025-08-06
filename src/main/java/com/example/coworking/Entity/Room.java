package com.example.coworking.Entity;


import com.example.coworking.Enum.Type;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Room{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Type type;
    private String description;
    private String capacity;
    private String image;
    private Double price;
    // ✅ Relation vers l'espace de coworking auquel appartient la salle
    @ManyToOne
    @JoinColumn(name = "space_id")
    private CoworkingSpace space;
}
