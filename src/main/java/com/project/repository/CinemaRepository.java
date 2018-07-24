package com.project.repository;

import com.project.model.cinemaproject.cinemadecorator.Cinema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends MongoRepository<Cinema,String> {
}
