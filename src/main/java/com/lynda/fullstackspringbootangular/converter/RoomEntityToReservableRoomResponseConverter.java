package com.lynda.fullstackspringbootangular.converter;

import com.lynda.fullstackspringbootangular.entity.RoomEntity;
import com.lynda.fullstackspringbootangular.model.Links;
import com.lynda.fullstackspringbootangular.model.Self;
import com.lynda.fullstackspringbootangular.model.response.ReservableRoomResponse;
import com.lynda.fullstackspringbootangular.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse>{

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();

		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice(source.getPrice());

		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);

		reservationResponse.setLinks(links);

		return reservationResponse;
	}



}
