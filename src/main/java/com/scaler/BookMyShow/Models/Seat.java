package com.scaler.BookMyShow.Models;

import com.scaler.BookMyShow.Models.constants.BaseModel;
import com.scaler.BookMyShow.Models.constants.SeatType;
import com.scaler.BookMyShow.Models.constants.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel {
    private int seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private Status seatStatus;
    @ManyToOne
    private Auditorium auditorium;

}
