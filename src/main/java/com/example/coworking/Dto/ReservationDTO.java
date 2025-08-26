package com.example.coworking.Dto;

import com.example.coworking.Enum.ReservationStatus;
import java.time.LocalDateTime;

public class ReservationDTO {

    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ReservationStatus status;
    private Double totalPrice;
    private Long userId;
    private Long roomId;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, LocalDateTime startTime, LocalDateTime endTime,
                          ReservationStatus status, Double totalPrice, Long userId, Long roomId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.totalPrice = totalPrice;
        this.userId = userId;
        this.roomId = roomId;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public ReservationStatus getStatus() { return status; }
    public void setStatus(ReservationStatus status) { this.status = status; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getRoomId() { return roomId; }
    public void setRoomId(Long roomId) { this.roomId = roomId; }
}
