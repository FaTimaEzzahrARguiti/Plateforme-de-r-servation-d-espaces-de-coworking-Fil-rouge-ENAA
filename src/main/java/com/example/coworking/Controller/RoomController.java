package com.example.coworking.Controller;


import com.example.coworking.Dto.RoomDTO;
import com.example.coworking.Service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @PostMapping
    public RoomDTO addRoom(@RequestBody RoomDTO dto){
        return roomService.createRoom(dto);
    }


    @GetMapping
    public List<RoomDTO> getAll(){
        return roomService.getAllRooms();
    }


    @PutMapping("/{id}")
    public RoomDTO update(@PathVariable Long id, @RequestBody RoomDTO dto){
        return roomService.updateRoom(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        roomService.deleteRoom(id);
    }


    @GetMapping("/{id}")
    public RoomDTO getById(@PathVariable Long id){
        return roomService.getRoomById(id);

    }

    @GetMapping("/coworking-spaces/{spaceId}/rooms")
    public List<RoomDTO> getRoomsBySpace(@PathVariable Long spaceId){
        return roomService.getRoomsByCoworkingSpaceId(spaceId);
    }
}
