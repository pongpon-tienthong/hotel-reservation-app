package com.lynda.fullstackspringbootangular.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

	public RoomEntity() {
	}

	public RoomEntity(Integer roomNumber, Integer price) {
		this.roomNumber = roomNumber;
		this.price = price;
	}
}
