package com.scaler.BookMyShow.Services;

import com.scaler.BookMyShow.Exceptions.SeatNotAvailableException;
import com.scaler.BookMyShow.Models.ShowSeat;
import com.scaler.BookMyShow.Models.Ticket;
import com.scaler.BookMyShow.Models.constants.ShowSeatStatus;
import com.scaler.BookMyShow.Models.constants.TicketStatus;
import com.scaler.BookMyShow.Repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Override
    @Transactional(isolation=Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws Exception {
        Ticket ticket=new Ticket();
        for(Integer seatId:showSeatIds){
            ShowSeat seat=showSeatRepository.findById(seatId).get();
            if (!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new SeatNotAvailableException("Seat not available");
            }

        }
        List<ShowSeat> seats=new ArrayList<>();
        //Locking the seat
        for(Integer seatId:showSeatIds){
            ShowSeat seat=showSeatRepository.findById(seatId).get();
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            ShowSeat resSeat=showSeatRepository.save(seat);
            seats.add(resSeat);
        }
        ticket.setShowSeats(seats);
         ShowSeat seat=ticket.getShowSeats().get(0);
          ticket.setTicketStatus(TicketStatus.BOOKED);
          ticket.setShow(seat.getShow());
          ticket.setTimeOfBooking(LocalDateTime.now());
        return ticket;
    }
}
