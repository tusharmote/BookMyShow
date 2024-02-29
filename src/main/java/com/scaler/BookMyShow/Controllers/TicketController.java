package com.scaler.BookMyShow.Controllers;

import com.scaler.BookMyShow.DTOs.TicketRequestDTO;
import com.scaler.BookMyShow.DTOs.TicketResponseDTO;
import com.scaler.BookMyShow.Models.ShowSeat;
import com.scaler.BookMyShow.Models.Ticket;
import com.scaler.BookMyShow.Services.TicketService;
import com.scaler.BookMyShow.Services.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @PostMapping("/ticket")
    public ResponseEntity<?> createTicket(@RequestBody TicketRequestDTO ticketRequestDTO) throws Exception {
        Ticket ticket=ticketService.bookTicket(ticketRequestDTO.getShowSeatIDs(), ticketRequestDTO.getUserID());
//        if(ticket!=null) {
//            return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<String>("ticket not found",HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(getTicketDTO(ticket));
    }


    List<Integer> seats=new ArrayList<>();
    int total=0;
    public TicketResponseDTO getTicketDTO(Ticket ticket){
        TicketResponseDTO ticketResponseDTO=new TicketResponseDTO();
        ticketResponseDTO.setAuditoriumName(ticket.getShow().getAuditorium().getName());
        for(ShowSeat seat:ticket.getShowSeats()){
            seats.add(seat.getId());
            total+=seat.getPrice();
        }
        ticketResponseDTO.setTotalAmount(total);
        ticketResponseDTO.setSeatNumbers(seats);
        ticketResponseDTO.setMovieName(ticket.getShow().getMovie().getName());
        ticketResponseDTO.setTimeOfShow(ticket.getShow().getStart_time());
        ticketResponseDTO.setTheatreName(ticket.getShow().getAuditorium().getTheatre().getName());
        return ticketResponseDTO;
    }
}
