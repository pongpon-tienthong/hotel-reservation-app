package com.lynda.fullstackspringbootangular.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Room")
public class RoomEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Integer roomNumber;

	@NotNull
	private Integer price;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<ReservationEntity> reservationEntityList;

	public RoomEntity() {
	}

	public RoomEntity(Integer roomNumber, Integer price) {
		this.roomNumber = roomNumber;
		this.price = price;
	}

	public void addReservationEntity(ReservationEntity reservationEntity) {
		if (null == reservationEntityList)
			reservationEntityList = new ArrayList<>();

		reservationEntityList.add(reservationEntity);
	}
}
