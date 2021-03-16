package com.example.warehouse.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonDataLoaderTest {

    private JsonDataLoader jsonDataLoader;

    @BeforeEach
    void setUp() {
        jsonDataLoader = new JsonDataLoader();
    }

    @Test
    void getWarehouse() throws JsonProcessingException {
        var v = jsonDataLoader.getWarehouse();
        System.out.println(v);
    }
}