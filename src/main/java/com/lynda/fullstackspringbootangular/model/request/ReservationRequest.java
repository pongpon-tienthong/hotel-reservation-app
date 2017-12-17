package com.lynda.fullstackspringbootangular.model.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ReservationRequest {

    private Long id;

    private Long roomId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkin;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkout;

    public ReservationRequest() {
    }

    public ReservationRequest(Long id, Long roomId, LocalDate checkin, LocalDate checkout) {
        this.id = id;
        this.roomId = roomId;
        this.checkin = checkin;
        this.checkout = checkout;
    }
}
