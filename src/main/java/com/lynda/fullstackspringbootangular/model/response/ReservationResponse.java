package com.lynda.fullstackspringbootangular.model.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationResponse {

    private Long id;
    private LocalDate checkin;
    private LocalDate checkout;

    public ReservationResponse() {
    }

    public ReservationResponse(Long id, LocalDate checkin, LocalDate checkout) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
    }
}