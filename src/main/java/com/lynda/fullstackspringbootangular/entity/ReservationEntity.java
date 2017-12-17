package com.lynda.fullstackspringbootangular.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate checkin;

    @NotNull
    private LocalDate checkout;

    @ManyToOne
    private RoomEntity roomEntity;

    public ReservationEntity() {
    }

    public ReservationEntity(LocalDate checkin, LocalDate checkout, RoomEntity roomEntity) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomEntity = roomEntity;
    }
}