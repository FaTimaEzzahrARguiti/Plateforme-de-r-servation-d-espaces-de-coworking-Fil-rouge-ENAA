package com.example.coworking.Repository;

import com.example.coworking.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findBySpaceId(Long spaceId);

}
