package com.scaler.BookMyShow.Models;

import com.scaler.BookMyShow.Models.constants.BaseModel;
import com.scaler.BookMyShow.Models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel {
    private int totalAmount;
    private LocalDateTime timeOfBooking;
    @ManyToOne
    private Show1 show;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    @ManyToMany
    private List<ShowSeat> showSeats;



}
