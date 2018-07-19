package com.project.repository;

import com.project.model.cinemaproject.cinemadecorator.BasicCinema;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CinemaClubRepository extends MongoRepository<BasicCinema,UUID> {
}
