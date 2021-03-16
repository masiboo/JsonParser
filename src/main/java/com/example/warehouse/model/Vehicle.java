package com.example.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    @JsonProperty("_id")
    private int id;
    private String mark;
    private String model;
    @JsonProperty("year_model")
    private int year;
    private double price;
    private boolean licensed;
    @JsonProperty("date_added")
    private Instant dateAdded;
}
