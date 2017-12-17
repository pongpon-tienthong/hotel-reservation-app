package com.lynda.fullstackspringbootangular.model.response;

import com.lynda.fullstackspringbootangular.model.Links;
import lombok.Data;

@Data
public class ReservableRoomResponse {

    private Long id;
    private Integer roomNumber;
    private Integer price;
    private Links links;

    public ReservableRoomResponse() {
    }

    public ReservableRoomResponse(Integer roomNumber, Integer price) {
        this.roomNumber = roomNumber;
        this.price = price;
    }
}
