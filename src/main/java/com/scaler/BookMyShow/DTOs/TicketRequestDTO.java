package com.scaler.BookMyShow.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class TicketRequestDTO {
   // private int show_id;
    private List<Integer> showSeatIDs;
    private int userID;
}
