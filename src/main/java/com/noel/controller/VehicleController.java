package com.noel.controller;

import com.noel.model.Vehicle;
import com.noel.service.VehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
    // http://localhost:8081/vehicles
    private final VehicleService vehicleService;

    @PostMapping
    public Vehicle create(@Valid @RequestBody Vehicle vehicle) {
        return vehicleService.create(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{vehicleId}")
    public Vehicle getVehicle(@PathVariable String vehicleId) {
        return vehicleService.findById(vehicleId);
    }

    // http://localhost:8081/vehicles/{vehicleId}/user/{userId}
    @PostMapping("/{vehicleId}/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void associateVehicle(@PathVariable String vehicleId, @PathVariable String userId) {
        vehicleService.associate(vehicleId, userId);
    }

    @DeleteMapping("/{vehicleId}/user/{userId}")
    public void removeAssociation(@PathVariable String vehicleId, @PathVariable String userId) {
        vehicleService.removeAssociation(vehicleId, userId);
    }
}