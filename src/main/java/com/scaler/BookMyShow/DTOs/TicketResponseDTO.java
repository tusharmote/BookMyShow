package com.scaler.BookMyShow.DTOs;

import com.scaler.BookMyShow.Models.Seat;
import com.scaler.BookMyShow.Models.ShowSeat;
import com.scaler.BookMyShow.Models.Theatre;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class TicketResponseDTO {
    private LocalDateTime timeOfShow;
    private List<Integer> seatNumbers;
    private int totalAmount;
    private String theatreName;
    private String auditoriumName;
    private String movieName;

}
