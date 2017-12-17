package com.lynda.fullstackspringbootangular.repository;

import com.lynda.fullstackspringbootangular.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
}