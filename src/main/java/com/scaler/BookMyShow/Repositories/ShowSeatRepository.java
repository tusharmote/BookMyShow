package com.scaler.BookMyShow.Repositories;

import com.scaler.BookMyShow.Models.ShowSeat;
import jakarta.persistence.LockModeType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer>{
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    ShowSeat save(ShowSeat seat);

}
