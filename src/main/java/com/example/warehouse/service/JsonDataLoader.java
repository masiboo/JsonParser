package com.example.warehouse.service;

import com.example.warehouse.model.Warehouse;
import com.example.warehouse.model.WarehousesData;
import com.example.warehouse.model.Wrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonDataLoader {

    ObjectMapper mapper = new ObjectMapper();

    public JsonDataLoader() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public Warehouse[] getWarehouse() throws JsonProcessingException {
        Warehouse[] warehouses = mapper.readValue(WarehousesData.jsonData, Warehouse[].class);
        return warehouses;
    }

    public String getPrettyJson(Object object) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

}
