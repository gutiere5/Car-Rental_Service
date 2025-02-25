package com.noel.controller;

import com.noel.model.Vehicle;
import com.noel.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
    // http://localhost:8081/vehicles


    private final VehicleService vehicleService;

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleService.create(vehicle);
    }
}
