package com.scaler.BookMyShow.Models;

import com.scaler.BookMyShow.Models.constants.BaseModel;
import com.scaler.BookMyShow.Models.constants.PaymentMethod;
import com.scaler.BookMyShow.Models.constants.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Payment extends BaseModel {
    private int referenceId;
    private int amount;
    private LocalDateTime paymentTime;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @ManyToOne
    private Ticket ticket;
    @OneToMany
    private List<Transaction> transactions;

}
