package com.lynda.fullstackspringbootangular.model.response;

import com.lynda.fullstackspringbootangular.model.Links;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class ReservationResponse {
    private Long id;
    private Integer roomNumber;
    private Integer price;
    private Links links;
}
