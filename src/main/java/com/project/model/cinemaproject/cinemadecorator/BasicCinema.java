package com.project.model.cinemaproject.cinemadecorator;

import com.project.model.cinemaproject.Currency;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Document
public class BasicCinema implements Cinema{

    @Id
    private UUID id;
    private String cinemaName;
    private int currentMoney;
    @Max(100)
    @Min(0)
    private int purity;
    private int seats;
    @Max(100)
    @Min(0)
    private int maintained;
    private Currency currency;


    public BasicCinema() {
    }

    @Override
    public int getCurrenctMoney() {
        return currentMoney;
    }

}
