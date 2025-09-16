package com.example.coworking.Repository;

import com.example.coworking.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findBySpaceId(Long spaceId);
    @Query(value = "select r from Room r inner join Reservation rs on r.id=rs.room.id inner join User u on u.id=rs.user.id where u.id=:UserId")
    List<Room> findByUserId(Long UserId);

}
