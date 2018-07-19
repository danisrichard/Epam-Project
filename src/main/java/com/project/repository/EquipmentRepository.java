package com.project.repository;

import com.project.model.cinemaproject.equipment.Equipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends MongoRepository<Equipment,String> {
}
