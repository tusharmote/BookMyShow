package com.scaler.BookMyShow.Models;

import com.scaler.BookMyShow.Models.constants.AuditoriumFeatures;
import com.scaler.BookMyShow.Models.constants.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;
    private int capacity;

    @OneToMany
    private List<Show1> shows;
    @OneToMany
    private List<Seat> seats;
    @ManyToOne()
    private Theatre theatre;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeatures> auditoriumFeatures;
}
