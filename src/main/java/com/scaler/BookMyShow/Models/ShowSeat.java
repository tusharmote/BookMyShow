package com.scaler.BookMyShow.Models;

import com.scaler.BookMyShow.Models.constants.BaseModel;
import com.scaler.BookMyShow.Models.constants.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeat extends BaseModel {
    private int price;
    @ManyToOne
    private Show1 show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}
