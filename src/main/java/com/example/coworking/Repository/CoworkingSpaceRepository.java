package com.example.coworking.Repository;

import com.example.coworking.Dto.NombreReservation;
import com.example.coworking.Entity.CoworkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoworkingSpaceRepository extends JpaRepository<CoworkingSpace,Long> {

    @Query(value = "select count(r) as nombre ,r.space.id as id from Room r where r.isAvailable=true GROUP BY r.space.id")
    List<NombreReservation> CountReservation();


}
