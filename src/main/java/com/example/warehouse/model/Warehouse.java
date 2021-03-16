package com.example.warehouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Warehouse {
    @JsonProperty("_id")
    private int id;
    private String name;
    Location location;
    Car cars;
}
