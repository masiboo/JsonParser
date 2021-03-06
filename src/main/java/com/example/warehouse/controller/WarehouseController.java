package com.example.warehouse.controller;

import com.example.warehouse.model.Warehouse;
import com.example.warehouse.service.WarehouseService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = WarehouseController.REQUEST_URL)
public class WarehouseController {

    public static final String REQUEST_URL = "/api/v1/revisions/";
    public static final String GET_ALL_WARE_HOUSES = "warehouse";
    private final String PAGE_LIMIT = "100";

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping(value = GET_ALL_WARE_HOUSES, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "page number"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
    })
    public Page<Warehouse> getAllWarehouse(
            Pageable pageable,
            @ApiParam(value = "sortBy - eg. created, id, fileName")
            @RequestParam(value = "sort_by", required = false, defaultValue = "created") String sortBy,

            @ApiParam(value = "sortDirection (desc/asc)")
            @RequestParam(value = "sort_direction", required = false, defaultValue = "asc") String sortDirection,

            @RequestParam(value = "limit", required = false, defaultValue = PAGE_LIMIT) int limit) {

        var direction = Sort.Direction.fromString(sortDirection);
        var sort = Sort.by(direction, sortBy);
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);

        var warehouses = warehouseService.getAllWareHouses();

        return warehouseService.buildPageable(warehouses, pageable);

    }

}
