package com.project.service.Impl.cinema;

import com.project.service.CinemaClubServiceDayEndService;
import com.project.utils.CinemaInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaClubOneDayServiceImpl implements CinemaClubServiceDayEndService {

    @Autowired
    private CinemaInputValidator cinemaInputValidator;



}
