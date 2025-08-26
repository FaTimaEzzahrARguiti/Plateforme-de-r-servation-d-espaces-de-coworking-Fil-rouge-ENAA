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
    @Enumerated(EnumType.STRING) // ✅ Had l-ligne hiya l-jadida bach t-kheddem l-Enum
    private Type type;
    private String description;
    private String capacity;
    private String image;
    private Double price;

    // ✅ La relation vers l'espace de coworking
    @ManyToOne
    @JoinColumn(name = "space_id")
    private CoworkingSpace space;
}