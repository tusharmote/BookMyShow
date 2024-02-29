package com.scaler.BookMyShow.Services;

import com.scaler.BookMyShow.Exceptions.SeatNotAvailableException;
import com.scaler.BookMyShow.Models.Ticket;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TicketService {
    @Transactional(isolation= Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds,int userId) throws Exception;
}
