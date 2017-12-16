package com.lynda.fullstackspringbootangular.repository;

import com.lynda.fullstackspringbootangular.entity.RoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

}
